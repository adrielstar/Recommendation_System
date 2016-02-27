package com.company;

import com.company.model.User;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Quincy on 2/12/2016.
 */
public class UserPreference {
    private Map<Integer, Map<Integer, Double>> mUserItemData = new HashMap<>();
    private List<User> mUserList = new ArrayList<>();
    private User mUser;

    public Map readFile(String fileName) {

        try (
            FileInputStream inputStream = new FileInputStream(fileName);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] args = line.split(",");

                int userId = Integer.parseInt(args[0]);
                int itemId = Integer.parseInt(args[1]);
                double rating = Double.parseDouble(args[2]);

                if (!mUserList.contains(userId)) {
                    mUser = new User(userId);
                    mUserList.add(mUser);
                }

                if (!mUserList.isEmpty()) {
                    addRatingToUser(userId, itemId, rating);
                }

                if (!mUserItemData.containsKey(mUser.getId())) {
                    mUserItemData.put(mUser.getId(), mUser.getRatedItems());
                }
            }

        } catch (IOException e) {
            System.out.printf("Problem loading: %s %n", fileName);
            e.printStackTrace();
        }
        return mUserItemData;
    }

    public void addRatingToUser(int userId, int itemId, double rating) {
        mUserList.stream().filter(user -> user.getId() == userId).forEach(user -> user.addRatedItems(itemId, rating));
    }
}
