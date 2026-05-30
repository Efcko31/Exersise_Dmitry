package ru.lectures.Patterns.BehavioralPatterns.Iterator.GoingThroughSocialNetworkProfiles;

public interface ProfileIterator {
    boolean hasNext();

    Profile getNext();

    void reset();
}
