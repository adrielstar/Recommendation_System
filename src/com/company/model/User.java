package com.company.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Quincy on 2/12/2016.
 */
public class User {

    private int mId;
    private HashMap<Integer, Double> mRatedItems = new HashMap<>();

    public User(int id) {
        mId = id;
        mRatedItems = new HashMap<>();
    }

    public int getId() {
        return mId;
    }

    public Map<Integer, Double> getRatedItems() {
        return mRatedItems;
    }

    public void addRatedItems(int itemId, double rating) {
        mRatedItems.put(itemId, rating);
    }
}
