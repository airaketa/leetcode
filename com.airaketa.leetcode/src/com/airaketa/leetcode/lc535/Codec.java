package com.airaketa.leetcode.lc535;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * https://leetcode.com/problems/encode-and-decode-tinyurl/
 */
public class Codec {
    private Map<String, Map<String, String>> distributedCash = new HashMap<>();
    private static final String DOMAIN = "http://tinyurl.com/";

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String hash = Integer.toString(Objects.hash(longUrl));
        String nodeKey = hash.substring(0, 3);
        Map<String, String> cacheNode = distributedCash.computeIfAbsent(nodeKey, key -> new HashMap<>());

        cacheNode.put(hash, longUrl);
        return DOMAIN + hash;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String hash = shortUrl.replace(DOMAIN, "");
        String nodeKey = hash.substring(0, 3);
        Map<String, String> cacheNode = distributedCash.get(nodeKey);
        if (cacheNode == null) {
            return "";
        }
        else {
            return cacheNode.get(hash);
        }
    }
}