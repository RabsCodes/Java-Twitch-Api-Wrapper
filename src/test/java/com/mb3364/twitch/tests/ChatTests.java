package com.mb3364.twitch.tests;

import com.mb3364.twitch.api.Twitch;
import com.mb3364.twitch.api.handlers.BadgesResponseHandler;
import com.mb3364.twitch.api.handlers.EmoticonsResponseHandler;
import com.mb3364.twitch.api.models.ChannelBadges;
import com.mb3364.twitch.api.models.Emoticon;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class ChatTests {

    private final static String CLIENT_ID = "3ecse7kg5j1tmagtkmzzyxqmvtw1lze";

    private Twitch client;

    @Before
    public void before() {
        client = new Twitch();
        client.setClientId(CLIENT_ID);
    }

    @After
    public void after() throws InterruptedException {
        Thread.sleep(5000);
    }

    @Test
    public void emoticonsTest() {
        Twitch client = new Twitch();
        client.chat().getEmoticons(new EmoticonsResponseHandler() {
            @Override
            public void onSuccess(List<Emoticon> emoticons) {
                System.out.println(emoticons);
            }

            @Override
            public void onFailure(int statusCode, String statusMessage, String errorMessage) {
                System.out.println(statusCode + " " + statusMessage + " " + errorMessage);
            }

            @Override
            public void onFailure(Throwable e) {
                e.printStackTrace();
            }
        });
    }

    @Test
    public void badgesTest() {
        Twitch client = new Twitch();
        client.chat().getBadges("lirik", new BadgesResponseHandler() {
            @Override
            public void onSuccess(ChannelBadges badges) {
                System.out.println(badges);
            }

            @Override
            public void onFailure(int statusCode, String statusMessage, String errorMessage) {
                System.out.println(statusCode + " " + statusMessage + " " + errorMessage);
            }

            @Override
            public void onFailure(Throwable e) {
                e.printStackTrace();
            }
        });
    }
}
