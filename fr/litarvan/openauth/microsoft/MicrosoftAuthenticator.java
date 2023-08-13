/*     */ package fr.litarvan.openauth.microsoft;
/*     */ 
/*     */ import fr.litarvan.openauth.microsoft.model.request.MinecraftLoginRequest;
/*     */ import fr.litarvan.openauth.microsoft.model.request.XSTSAuthorizationProperties;
/*     */ import fr.litarvan.openauth.microsoft.model.request.XboxLiveLoginProperties;
/*     */ import fr.litarvan.openauth.microsoft.model.request.XboxLoginRequest;
/*     */ import fr.litarvan.openauth.microsoft.model.response.MicrosoftRefreshResponse;
/*     */ import fr.litarvan.openauth.microsoft.model.response.MinecraftLoginResponse;
/*     */ import fr.litarvan.openauth.microsoft.model.response.MinecraftProfile;
/*     */ import fr.litarvan.openauth.microsoft.model.response.MinecraftStoreResponse;
/*     */ import fr.litarvan.openauth.microsoft.model.response.XboxLoginResponse;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.net.CookieHandler;
/*     */ import java.net.CookieManager;
/*     */ import java.net.CookiePolicy;
/*     */ import java.net.HttpURLConnection;
/*     */ import java.net.URLDecoder;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.CompletableFuture;
/*     */ import java.util.concurrent.CompletionException;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MicrosoftAuthenticator
/*     */ {
/*     */   public static final String MICROSOFT_AUTHORIZATION_ENDPOINT = "https://login.live.com/oauth20_authorize.srf";
/*     */   public static final String MICROSOFT_TOKEN_ENDPOINT = "https://login.live.com/oauth20_token.srf";
/*     */   public static final String MICROSOFT_REDIRECTION_ENDPOINT = "https://login.live.com/oauth20_desktop.srf";
/*     */   public static final String XBOX_LIVE_AUTH_HOST = "user.auth.xboxlive.com";
/*     */   public static final String XBOX_LIVE_CLIENT_ID = "000000004C12AE6F";
/*     */   public static final String XBOX_LIVE_SERVICE_SCOPE = "service::user.auth.xboxlive.com::MBI_SSL";
/*     */   public static final String XBOX_LIVE_AUTHORIZATION_ENDPOINT = "https://user.auth.xboxlive.com/user/authenticate";
/*     */   public static final String XSTS_AUTHORIZATION_ENDPOINT = "https://xsts.auth.xboxlive.com/xsts/authorize";
/*     */   public static final String MINECRAFT_AUTH_ENDPOINT = "https://api.minecraftservices.com/authentication/login_with_xbox";
/*     */   public static final String XBOX_LIVE_AUTH_RELAY = "http://auth.xboxlive.com";
/*     */   public static final String MINECRAFT_AUTH_RELAY = "rp://api.minecraftservices.com/";
/*     */   public static final String MINECRAFT_STORE_ENDPOINT = "https://api.minecraftservices.com/entitlements/mcstore";
/*     */   public static final String MINECRAFT_PROFILE_ENDPOINT = "https://api.minecraftservices.com/minecraft/profile";
/*     */   public static final String MINECRAFT_STORE_IDENTIFIER = "game_minecraft";
/*  81 */   private final HttpClient http = new HttpClient();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MicrosoftAuthResult loginWithCredentials(String email, String password) throws MicrosoftAuthenticationException {
/*     */     HttpURLConnection result;
/*  97 */     CookieHandler currentHandler = CookieHandler.getDefault();
/*  98 */     CookieHandler.setDefault(new CookieManager(null, CookiePolicy.ACCEPT_ALL));
/*     */     
/* 100 */     Map<String, String> params = new HashMap<>();
/* 101 */     params.put("login", email);
/* 102 */     params.put("loginfmt", email);
/* 103 */     params.put("passwd", password);
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 108 */       PreAuthData authData = preAuthRequest();
/* 109 */       params.put("PPFT", authData.getPPFT());
/*     */       
/* 111 */       result = this.http.followRedirects(this.http.postForm(authData.getUrlPost(), params));
/*     */     } finally {
/* 113 */       CookieHandler.setDefault(currentHandler);
/*     */     } 
/*     */     
/*     */     try {
/* 117 */       return loginWithTokens(extractTokens(result.getURL().toString()));
/* 118 */     } catch (MicrosoftAuthenticationException e) {
/* 119 */       if (match("identity/confirm", this.http.readResponse(result)) != null) {
/* 120 */         throw new MicrosoftAuthenticationException("User has enabled double-authentication or must allow sign-in on https://account.live.com/activity");
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 125 */       throw e;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MicrosoftAuthResult loginWithWebview() throws MicrosoftAuthenticationException {
/*     */     try {
/* 142 */       return loginWithAsyncWebview().get();
/* 143 */     } catch (InterruptedException|java.util.concurrent.ExecutionException e) {
/* 144 */       throw new MicrosoftAuthenticationException(e);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CompletableFuture<MicrosoftAuthResult> loginWithAsyncWebview() {
/* 155 */     String url = String.format("%s?%s", new Object[] { "https://login.live.com/oauth20_authorize.srf", this.http.buildParams(getLoginParams()) });
/* 156 */     LoginFrame frame = new LoginFrame();
/*     */     
/* 158 */     return frame.start(url).thenApplyAsync(result -> {
/*     */           try {
/*     */             return loginWithTokens(extractTokens(result));
/* 161 */           } catch (MicrosoftAuthenticationException e) {
/*     */             throw new CompletionException(e);
/*     */           } 
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MicrosoftAuthResult loginWithRefreshToken(String refreshToken) throws MicrosoftAuthenticationException {
/* 178 */     Map<String, String> params = getLoginParams();
/* 179 */     params.put("refresh_token", refreshToken);
/* 180 */     params.put("grant_type", "refresh_token");
/*     */     
/* 182 */     MicrosoftRefreshResponse response = this.http.<MicrosoftRefreshResponse>postFormGetJson("https://login.live.com/oauth20_token.srf", params, MicrosoftRefreshResponse.class);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 187 */     return loginWithTokens(new AuthTokens(response.getAccessToken(), response.getRefreshToken()));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MicrosoftAuthResult loginWithTokens(AuthTokens tokens) throws MicrosoftAuthenticationException {
/* 202 */     XboxLoginResponse xboxLiveResponse = xboxLiveLogin(tokens.getAccessToken());
/* 203 */     XboxLoginResponse xstsResponse = xstsLogin(xboxLiveResponse.getToken());
/*     */     
/* 205 */     String userHash = xstsResponse.getDisplayClaims().getUsers()[0].getUserHash();
/* 206 */     MinecraftLoginResponse minecraftResponse = minecraftLogin(userHash, xstsResponse.getToken());
/* 207 */     MinecraftStoreResponse storeResponse = this.http.<MinecraftStoreResponse>getJson("https://api.minecraftservices.com/entitlements/mcstore", minecraftResponse
/*     */         
/* 209 */         .getAccessToken(), MinecraftStoreResponse.class);
/*     */ 
/*     */ 
/*     */     
/* 213 */     if (Arrays.<MinecraftStoreResponse.StoreProduct>stream(storeResponse.getItems()).noneMatch(item -> item.getName().equals("game_minecraft"))) {
/* 214 */       throw new MicrosoftAuthenticationException("Player didn't buy Minecraft Java Edition or did not migrate its account");
/*     */     }
/*     */     
/* 217 */     MinecraftProfile profile = this.http.<MinecraftProfile>getJson("https://api.minecraftservices.com/minecraft/profile", minecraftResponse
/*     */         
/* 219 */         .getAccessToken(), MinecraftProfile.class);
/*     */ 
/*     */ 
/*     */     
/* 223 */     return new MicrosoftAuthResult(profile, minecraftResponse.getAccessToken(), tokens.getRefreshToken());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected PreAuthData preAuthRequest() throws MicrosoftAuthenticationException {
/* 229 */     Map<String, String> params = getLoginParams();
/* 230 */     params.put("display", "touch");
/* 231 */     params.put("locale", "en");
/*     */     
/* 233 */     String result = this.http.getText("https://login.live.com/oauth20_authorize.srf", params);
/*     */     
/* 235 */     String ppft = match("sFTTag:'.*value=\"([^\"]*)\"", result);
/* 236 */     String urlPost = match("urlPost: ?'(.+?(?='))", result);
/*     */     
/* 238 */     return new PreAuthData(ppft, urlPost);
/*     */   }
/*     */ 
/*     */   
/*     */   protected XboxLoginResponse xboxLiveLogin(String accessToken) throws MicrosoftAuthenticationException {
/* 243 */     XboxLiveLoginProperties properties = new XboxLiveLoginProperties("RPS", "user.auth.xboxlive.com", accessToken);
/* 244 */     XboxLoginRequest<XboxLiveLoginProperties> request = new XboxLoginRequest(properties, "http://auth.xboxlive.com", "JWT");
/*     */ 
/*     */ 
/*     */     
/* 248 */     return this.http.<XboxLoginResponse>postJson("https://user.auth.xboxlive.com/user/authenticate", request, XboxLoginResponse.class);
/*     */   }
/*     */ 
/*     */   
/*     */   protected XboxLoginResponse xstsLogin(String xboxLiveToken) throws MicrosoftAuthenticationException {
/* 253 */     XSTSAuthorizationProperties properties = new XSTSAuthorizationProperties("RETAIL", new String[] { xboxLiveToken });
/* 254 */     XboxLoginRequest<XSTSAuthorizationProperties> request = new XboxLoginRequest(properties, "rp://api.minecraftservices.com/", "JWT");
/*     */ 
/*     */ 
/*     */     
/* 258 */     return this.http.<XboxLoginResponse>postJson("https://xsts.auth.xboxlive.com/xsts/authorize", request, XboxLoginResponse.class);
/*     */   }
/*     */ 
/*     */   
/*     */   protected MinecraftLoginResponse minecraftLogin(String userHash, String xstsToken) throws MicrosoftAuthenticationException {
/* 263 */     MinecraftLoginRequest request = new MinecraftLoginRequest(String.format("XBL3.0 x=%s;%s", new Object[] { userHash, xstsToken }));
/* 264 */     return this.http.<MinecraftLoginResponse>postJson("https://api.minecraftservices.com/authentication/login_with_xbox", request, MinecraftLoginResponse.class);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected Map<String, String> getLoginParams() {
/* 270 */     Map<String, String> params = new HashMap<>();
/* 271 */     params.put("client_id", "000000004C12AE6F");
/* 272 */     params.put("redirect_uri", "https://login.live.com/oauth20_desktop.srf");
/* 273 */     params.put("scope", "service::user.auth.xboxlive.com::MBI_SSL");
/* 274 */     params.put("response_type", "token");
/*     */     
/* 276 */     return params;
/*     */   }
/*     */ 
/*     */   
/*     */   protected AuthTokens extractTokens(String url) throws MicrosoftAuthenticationException {
/* 281 */     return new AuthTokens(extractValue(url, "access_token"), extractValue(url, "refresh_token"));
/*     */   }
/*     */ 
/*     */   
/*     */   protected String extractValue(String url, String key) throws MicrosoftAuthenticationException {
/* 286 */     String matched = match(key + "=([^&]*)", url);
/* 287 */     if (matched == null) {
/* 288 */       throw new MicrosoftAuthenticationException("Invalid credentials or tokens");
/*     */     }
/*     */     
/*     */     try {
/* 292 */       return URLDecoder.decode(matched, "UTF-8");
/* 293 */     } catch (UnsupportedEncodingException e) {
/* 294 */       throw new MicrosoftAuthenticationException(e);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected String match(String regex, String content) {
/* 300 */     Matcher matcher = Pattern.compile(regex).matcher(content);
/* 301 */     if (!matcher.find()) {
/* 302 */       return null;
/*     */     }
/*     */     
/* 305 */     return matcher.group(1);
/*     */   }
/*     */ }


/* Location:              C:\Users\PC\Downloads\neverlose public.jar!\fr\litarvan\openauth\microsoft\MicrosoftAuthenticator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */