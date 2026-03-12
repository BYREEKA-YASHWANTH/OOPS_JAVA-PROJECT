server.createContext("/api/recommend", exchange -> {
            if (!"GET".equalsIgnoreCase(exchange.getRequestMethod())) {
                sendText (exchange, 405, "Method Not Allowed"); return;
            }
            Map<String, String> q = splitQuery(exchange.getRequestURI().getRawQuery());
            UserProfile p = parseProfile(q);
            List<RecommenderService.Scored> recs = service.recommend(p);
            String json = toJson (p, recs);
            sendJson (exchange, 200, json); 
});
