package com.software.tempe.gitsocial.common;

import com.software.tempe.gitsocial.client.RClient;
import com.software.tempe.gitsocial.service.UserAPI;

public class Common {
    public static final String BASE_URL = "https://api.github.com";

    public static UserAPI getUserAll()  {
        return RClient.getRetrofitClient(BASE_URL).create(UserAPI.class);
    }

    public static String getUser(String q)  {
        StringBuilder api_url = new StringBuilder("https://api.github.com/search/users?q=");
        return api_url.append(q)
                .toString();
    }
}
