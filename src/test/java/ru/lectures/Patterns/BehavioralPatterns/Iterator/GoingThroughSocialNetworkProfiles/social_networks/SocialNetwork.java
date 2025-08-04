package ru.lectures.Patterns.BehavioralPatterns.Iterator.GoingThroughSocialNetworkProfiles.social_networks;

import ru.lectures.Patterns.BehavioralPatterns.Iterator.GoingThroughSocialNetworkProfiles.ProfileIterator;

public interface SocialNetwork {
    ProfileIterator createFriendsIterator(String profileEmail);

    ProfileIterator createCoworkersIterator(String profileEmail);
}
