package com.xite;


import com.codeborne.selenide.*;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Condition.*;
import static com.xite.PlayerPage.*;

public class MVPTest {

    @Before
    public void setUp() {
        Configuration.timeout = 5000;
        Configuration.collectionsTimeout = 5000;
        Configuration.browser = "chrome";
        Configuration.holdBrowserOpen = false;

    }

    @Test
    public void launchMVPShowsWelcomeTextTest() {
        launchMVP();
        userMessage.shouldHave(text("First, please help us build user profiles by liking the videos you really like, and skipping the rest"));
    }

    @Test
    public void likeSongTest() {
        launchMVP();
        String savedArtistTitle = artistTitle.getText();
        System.out.println(savedArtistTitle);

        likeSong();
        artistTitle.shouldNot(matchText(savedArtistTitle));
        System.out.println(artistTitle.getText());
    }

    @Test
    public void skipSongTest() {
        launchMVP();
        String savedArtistTitle = artistTitle.getText();
        System.out.println(savedArtistTitle);

        skipSong();
        artistTitle.shouldNot(matchText(savedArtistTitle));
        System.out.println(artistTitle.getText());
    }

    @Test
    public void quizToResultSetTransitionTest(){
        launchMVP();
        //skip to 2nd
        likeSong();
        //skip to 3rd
        likeSong();
        //skip to 4th
        likeSong();
        //skip to 5th
        likeSong();
        //skip to 6th
        likeSong();
        //skip to 7th
        likeSong();
        //skip to 8th
        likeSong();
        //skip to 9th
        likeSong();
        //skip to 10th
        likeSong();

        //skip to 11th
        skipSong();
        //skip to 12th
        skipSong();
        //skip to 13th
        skipSong();
        //skip to 14th
        skipSong();
        //skip to 15th
        skipSong();
        //skip to 16th
        skipSong();
        //skip to 17th
        skipSong();
        //skip to 18th
        skipSong();
        //skip to 19th
        skipSong();
        //skip to 20th
        skipSong();
        //skip to Results set
        skipSong();

        userMessage.shouldHave(text("Your user profile is stored. In the next set of videos, please provide feedback by liking what you like, and skipping what you don’t!"));

    }
}
