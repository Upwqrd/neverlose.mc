/*     */ package fr.litarvan.openauth;
/*     */ 
/*     */ import com.google.gson.Gson;
/*     */ import fr.litarvan.openauth.model.AuthAgent;
/*     */ import fr.litarvan.openauth.model.AuthError;
/*     */ import fr.litarvan.openauth.model.request.AuthRequest;
/*     */ import fr.litarvan.openauth.model.request.InvalidateRequest;
/*     */ import fr.litarvan.openauth.model.request.RefreshRequest;
/*     */ import fr.litarvan.openauth.model.request.SignoutRequest;
/*     */ import fr.litarvan.openauth.model.request.ValidateRequest;
/*     */ import fr.litarvan.openauth.model.response.AuthResponse;
/*     */ import fr.litarvan.openauth.model.response.RefreshResponse;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.DataOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import java.net.HttpURLConnection;
/*     */ import java.net.URL;
/*     */ import java.nio.charset.StandardCharsets;
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
/*     */ 
/*     */ public class Authenticator
/*     */ {
/*     */   public static final String MOJANG_AUTH_URL = "https://authserver.mojang.com/";
/*     */   private String authURL;
/*     */   private AuthPoints authPoints;
/*     */   
/*     */   public Authenticator(String authURL, AuthPoints authPoints) {
/*  69 */     this.authURL = authURL;
/*  70 */     this.authPoints = authPoints;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AuthResponse authenticate(AuthAgent agent, String username, String password, String clientToken) throws AuthenticationException {
/*  90 */     AuthRequest request = new AuthRequest(agent, username, password, clientToken);
/*  91 */     return (AuthResponse)sendRequest(request, AuthResponse.class, this.authPoints.getAuthenticatePoint());
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
/*     */ 
/*     */   
/*     */   public RefreshResponse refresh(String accessToken, String clientToken) throws AuthenticationException {
/* 108 */     RefreshRequest request = new RefreshRequest(accessToken, clientToken);
/* 109 */     return (RefreshResponse)sendRequest(request, RefreshResponse.class, this.authPoints.getRefreshPoint());
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
/*     */ 
/*     */   
/*     */   public void validate(String accessToken) throws AuthenticationException {
/* 126 */     ValidateRequest request = new ValidateRequest(accessToken);
/* 127 */     sendRequest(request, null, this.authPoints.getValidatePoint());
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
/*     */   public void signout(String username, String password) throws AuthenticationException {
/* 141 */     SignoutRequest request = new SignoutRequest(username, password);
/* 142 */     sendRequest(request, null, this.authPoints.getSignoutPoint());
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
/*     */   public void invalidate(String accessToken, String clientToken) throws AuthenticationException {
/* 156 */     InvalidateRequest request = new InvalidateRequest(accessToken, clientToken);
/* 157 */     sendRequest(request, null, this.authPoints.getInvalidatePoint());
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Object sendRequest(Object request, Class<?> model, String authPoint) throws AuthenticationException {
/*     */     String response;
/* 177 */     Gson gson = new Gson();
/*     */ 
/*     */     
/*     */     try {
/* 181 */       response = sendPostRequest(this.authURL + authPoint, gson.toJson(request));
/* 182 */     } catch (IOException e) {
/* 183 */       throw new AuthenticationException(new AuthError("Can't send the request : " + e.getClass().getName(), e.getMessage(), "Unknown"));
/*     */     } 
/*     */     
/* 186 */     if (model != null) {
/* 187 */       return gson.fromJson(response, model);
/*     */     }
/* 189 */     return null;
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
/*     */ 
/*     */   
/*     */   private String sendPostRequest(String url, String json) throws AuthenticationException, IOException {
/*     */     InputStream is;
/* 207 */     byte[] jsonBytes = json.getBytes(StandardCharsets.UTF_8);
/* 208 */     URL serverURL = new URL(url);
/* 209 */     HttpURLConnection connection = (HttpURLConnection)serverURL.openConnection();
/* 210 */     connection.setRequestMethod("POST");
/*     */ 
/*     */     
/* 213 */     connection.setDoOutput(true);
/* 214 */     connection.setRequestProperty("Accept-Charset", "UTF-8");
/* 215 */     connection.setRequestProperty("Content-Type", "application/json;charset=utf-8");
/* 216 */     connection.setRequestProperty("Content-Length", String.valueOf(jsonBytes.length));
/* 217 */     DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
/* 218 */     wr.write(jsonBytes, 0, jsonBytes.length);
/* 219 */     wr.flush();
/* 220 */     wr.close();
/*     */     
/* 222 */     connection.connect();
/*     */     
/* 224 */     int responseCode = connection.getResponseCode();
/*     */     
/* 226 */     if (responseCode == 204) {
/* 227 */       connection.disconnect();
/* 228 */       return null;
/*     */     } 
/*     */ 
/*     */     
/* 232 */     if (responseCode == 200) {
/* 233 */       is = connection.getInputStream();
/*     */     } else {
/* 235 */       is = connection.getErrorStream();
/*     */     } 
/*     */ 
/*     */     
/* 239 */     BufferedReader br = new BufferedReader(new InputStreamReader(is));
/* 240 */     String response = br.readLine();
/*     */     try {
/* 242 */       br.close();
/* 243 */     } catch (IOException e) {
/* 244 */       e.printStackTrace();
/*     */     } 
/* 246 */     connection.disconnect();
/*     */     
/* 248 */     while (response != null && response.startsWith("﻿")) {
/* 249 */       response = response.substring(1);
/*     */     }
/* 251 */     if (responseCode != 200) {
/* 252 */       Gson gson = new Gson();
/*     */       
/* 254 */       if (response != null && !response.startsWith("{")) {
/* 255 */         throw new AuthenticationException(new AuthError("Internal server error", response, "Remote"));
/*     */       }
/* 257 */       throw new AuthenticationException((AuthError)gson.fromJson(response, AuthError.class));
/*     */     } 
/*     */     
/* 260 */     return response;
/*     */   }
/*     */ }


/* Location:              C:\Users\PC\Downloads\neverlose public.jar!\fr\litarvan\openauth\Authenticator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */