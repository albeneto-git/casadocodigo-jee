package br.com.casadocodigo.loja.security;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.jboss.security.Base64Encoder;

public class PassGenerator {

	public static void main(String[] args) {
		System.out.println(new PassGenerator().generate("123"));
	}
	
	public String generate(String senhaTexto) {
		String senha = null;
		try {
			byte[] digest = MessageDigest.getInstance("sha-256").digest(senhaTexto.getBytes());
			senha = Base64Encoder.encode(digest);
		} catch (NoSuchAlgorithmException | IOException e) {
			e.printStackTrace();
		}
		return senha;
	}

}
