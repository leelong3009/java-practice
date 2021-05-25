package com.sample.common;

import org.jose4j.lang.JoseException;

import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;

public class JwtTest {

	public static void main(String[] args) throws JoseException {
//		RsaJsonWebKey rsaJsonWebKey = RsaJwkGenerator.generateJwk(2048);
		String token = "eyJraWQiOiJsTlltRk16NFFNamhsUVwvRVAzZlV2UFI0SnZqcU9LODdzUjRXTXcrcms2Yz0iLCJhbGciOiJSUzI1NiJ9.eyJzdWIiOiIydm1tc2VucHA1OW9zYWd2NGhuM2EwaWdmbyIsInRva2VuX3VzZSI6ImFjY2VzcyIsInNjb3BlIjoicGF5bm93LXFhLmFmdGVycGF5LmNvbVwvdjFcL3BheW1lbnRzXC9xdWVyeSBwYXlub3ctcWEuYWZ0ZXJwYXkuY29tXC92MVwvcmVmdW5kc1wvcXVlcnkgcGF5bm93LXFhLmFmdGVycGF5LmNvbVwvdjFcL3Jlc2VydmF0aW9uc1wvcmVzZXJ2ZSBwYXlub3ctcWEuYWZ0ZXJwYXkuY29tXC92MVwvcmVzZXJ2YXRpb25zXC9jYW5jZWwgcGF5bm93LXFhLmFmdGVycGF5LmNvbVwvdjFcL3Jlc2VydmF0aW9uc1wvcXVlcnkgcGF5bm93LXFhLmFmdGVycGF5LmNvbVwvdjFcL3Jlc2VydmF0aW9uc1wvY2FwdHVyZSBwYXlub3ctcWEuYWZ0ZXJwYXkuY29tXC92MVwvY2FyZHNcL3ZlcmlmeSBwYXlub3ctcWEuYWZ0ZXJwYXkuY29tXC92MVwvcGF5bWVudHNcL3JlZnVuZCBwYXlub3ctcWEuYWZ0ZXJwYXkuY29tXC92MVwvcGF5bWVudHNcL3JlcXVlc3QiLCJhdXRoX3RpbWUiOjE1OTg1NzM3NDQsImlzcyI6Imh0dHBzOlwvXC9jb2duaXRvLWlkcC5hcC1zb3V0aGVhc3QtMi5hbWF6b25hd3MuY29tXC9hcC1zb3V0aGVhc3QtMl9FckZHZGJNQTkiLCJleHAiOjE1OTg1NzczNDQsImlhdCI6MTU5ODU3Mzc0NCwidmVyc2lvbiI6MiwianRpIjoiZGNjYmU1OGEtYzYxMy00Y2MzLWFhY2ItZWRhYjU4ODFkYWNjIiwiY2xpZW50X2lkIjoiMnZtbXNlbnBwNTlvc2FndjRobjNhMGlnZm8ifQ.AHZCrnIUwmJsWXuPPTGAmMSdqJjngFi54tVXV-TT5csgyHsYZ_jGg0WdjtMYWJAVaZY5j5whH7j-PbnZsycc23rero9aesVlTa3jKj18z2K8afLjDbubqMs5hBUMbSiFN8YJ-Bcx1DkIH_rJSf19Gvn3kJf4kqq1_MdU1WTFvUcUGZXleHFiWp6EzoCnURc21OHc6gxl-g2LwZ0SljN_nfNkwgZcuxaY4isoXj-wkM78tFyQS_q-QLuEm375TpiCeBwGLkq6KNWaP14WtmHb8rCKj3X-zaicwwMvpGZHJKXL74WyrOeb0oA2aEK_3xyIKVwfFdA7hgXDf8DRvciPHg";
//		JwtConsumer jwtConsumer = new JwtConsumerBuilder()
//				.setVerificationKey(rsaJsonWebKey.getKey())
//			    .setRelaxVerificationKeyValidation()
//			    .setDisableRequireSignature()
//				.setJwsAlgorithmConstraints(ConstraintType.PERMIT, AlgorithmIdentifiers.RSA_USING_SHA256)
//				.build();
//		try {
//			JwtClaims jwtClaims = jwtConsumer.processToClaims(jwt);
//			System.out.println("JWT validation succeeded! " + jwtClaims);
//		} catch (InvalidJwtException e) {
//			System.out.println(e.getMessage());
//		}
		
		try {
		    DecodedJWT jwt = JWT.decode(token);
		    System.out.println(jwt.getKeyId());
		    System.out.println(jwt.getClaim("client_id").asString());
		} catch (JWTDecodeException exception){
		    //Invalid token
		}
	}

}
