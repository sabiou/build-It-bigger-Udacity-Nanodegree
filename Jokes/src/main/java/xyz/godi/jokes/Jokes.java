package xyz.godi.jokes;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Java class that set a list of jokes and provides them via a method
 */
public class Jokes {
    private static Random RANDOM_INT = new Random();

    // private constructeur to prevent class from instanciation
    private Jokes(){}

    /**
     * A list of jokes
     */
    private static String[] jokesList = {
            "Did Adam and Eve ever have a date? No, they had an apple!",
            "Did you hear about the bed bugs who fell in love? They’re getting married in the spring!",
            "How are stars like false teeth?. They both come out at night!",
            "Why do skunks love Valentine’s Day? Because they’re scent-imental creatures!",
            "Why aren’t dogs good dancers? Because they have two left feet!",
            "How did the telephone propose to its girlfriend? He gave her a ring.",
            "How do you prevent a Summer cold? Catch it in the Winter!",
            "Barista: How do you take your coffee? Me: Very, very seriously.",
            "What’s it called when you steal someone’s coffee? A: Mugging!",
            "How did the hipster burn his tongue? He drank his coffee before it was cool."
    };

    /**
     * Method that provides jokes
     */
    public static String provideJokes() {
        // we pass jokesList.length as nextInt() parameter as we want to return a random jokes from the list
        int index = RANDOM_INT.nextInt(jokesList.length);
        return jokesList[index];
    }
}