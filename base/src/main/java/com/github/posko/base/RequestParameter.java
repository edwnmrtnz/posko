package com.github.posko.base;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class RequestParameter {

    private HashMap<String, String> params = new HashMap<>();

    private RequestParameter(HashMap<String, String> params) {
        this.params = params;
    }

    public HashMap<String, String> getParams() {
        return params;
    }

    public static class Builder {

        private HashMap<String, String> params = new HashMap<>();

        public Builder sinceId(int id) {
            params.put("since_id", String.valueOf(id));
            return this;
        }

        public Builder page(int id) {
            params.put("page", String.valueOf(id));
            return this;
        }

        public Builder limit(int limit) {
            params.put("limit", String.valueOf(limit));
            return this;
        }

        public Builder ids(List<Integer> ids) {
            params.put("ids", Arrays.toString(ids.toArray(new Integer[0])));
            return this;
        }

        public Builder activeOnly() {
            params.put("status", "active");
            return this;
        }


        public RequestParameter build() {
            if(params.get("limit") == null) params.put("limit", String.valueOf(50));
            return new RequestParameter(params);
        }

    }
}
