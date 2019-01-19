package com.udacity.gradle.builditbigger.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import javax.inject.Named;

import xyz.godi.jokes.Jokes;

/** An endpoint class we are exposing */
@Api(
        name = "jokeApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.builditbigger.gradle.udacity.com",
                ownerName = "backend.builditbigger.gradle.udacity.com",
                packagePath = ""
        )
)
public class JokeEndpoint {

    /** A simple endpoint method that pull a joke and send it back */
    @ApiMethod(name = "tellJoke")
    public MyBean getJoke() {
        MyBean response = new MyBean();
        // get jokes from Joke library
        response.setData(Jokes.provideJokes());
        return response;
    }

}
