package com.azdes.connect.flickr;

import java.util.Scanner;

import org.scribe.model.Token;
import org.scribe.model.Verifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.azdes.connect.ConnectionException;
import com.azdes.connect.IConnect;
import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.FlickrException;
import com.flickr4java.flickr.REST;
import com.flickr4java.flickr.RequestContext;
import com.flickr4java.flickr.auth.Permission;

/**
 * Connects to Flickr
 * @author sbrougher
 */
@Service
public class FlickrConnect implements IConnect<Flickr> {
    
    @Value("${flickr.key}")
    private String apiKey;
    
    @Value("${flickr.secret}")
    private String sharedSecret;
    
    @Value("${flickr.authToken}")
    private String authToken;
    
    @Value("${flickr.authSecret}")
    private String authSecret;
    
    @Value("${flickr.authRaw}")
    private String authRaw;
    
    @Override
    public Flickr connect() throws ConnectionException {
        Flickr f = new Flickr(apiKey, sharedSecret, new REST());
        
        Token t = f.getAuthInterface().getRequestToken();
        System.out.println(f.getAuthInterface().getAuthorizationUrl(t, Permission.DELETE));
        System.out.print(">> ");
        //Scanner sc = new Scanner(System.in);
        
        //String oathVerifier = sc.nextLine();
        //sc.close();
        
        //System.out.println(oathVerifier);
        //Token accessToken = f.getAuthInterface().getAccessToken(t, new Verifier(oathVerifier));
        try {
            //RequestContext.getRequestContext().setAuth(f.getAuthInterface().checkToken(accessToken));
            RequestContext.getRequestContext().setAuth(f.getAuthInterface().checkToken(new Token(authToken, authSecret, authRaw)));
        } catch (FlickrException e) {
            throw new ConnectionException("Could not connect to Flickr", e);
        }
        return f;
    }
    
}
