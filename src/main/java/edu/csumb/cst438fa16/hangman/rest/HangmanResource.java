package edu.csumb.cst438fa16.hangman.rest;

import edu.csumb.cst438fa16.hangman.Hangman;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

/**
 * Hangman REST service.
 *
 * See:
 * https://jersey.java.net/documentation/latest/jaxrs-resources.html
 */
@Path("")
public class HangmanResource {
    static final String HANGMAN_WORD_PROPERTY_KEY = "hangman.word";

    private static Hangman getHangman() {
	String word = System.getProperty(HANGMAN_WORD_PROPERTY_KEY);
	return new Hangman(word);
    }

    @GET
    @Path("/start")
    public String start() {
	return getHangman().start();
    }

    @GET
    @Path("/match")
    public Response match(
        @QueryParam("oldPattern") String oldPattern,
        @QueryParam("oldGuesses") String oldGuesses,
        @QueryParam("newGuesses") String newGuesses
    ) {
	if (oldPattern == null || oldGuesses == null || newGuesses == null) {
            return Response.status(Response.Status.BAD_REQUEST)
	                   .entity("requires query parameters " +
				   "oldPattern, oldGuesses, newGuesses")
		           .build();
        }

	Hangman hangman = getHangman();
	if (!hangman.match(oldGuesses).equals(oldPattern)) {
            return Response.status(Response.Status.BAD_REQUEST)
	                   .entity("oldPattern, oldGuesses " +
				   "don't match the word")
		           .build();
        }
	return Response.ok(hangman.match(oldGuesses + newGuesses)).build();
    }
}
