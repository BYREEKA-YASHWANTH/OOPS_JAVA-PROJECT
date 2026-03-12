private static String toJson (UserProfile p, List<RecommenderService.Scored> recs) {
        StringBuilder sb = new StringBuilder ();
        sb.append("{\"profile\”: {")
                .append("\"age\":").append(p.age).append(',')
                .append("\"income\":").append(p.income).append(',')
         .append("\"occupation\":\"").append(jsonEscape(p.occupation)).append("\",")
                .append("\"category\":\"").append(jsonEscape(p.category)).append("\",")
                .append("\"location\":\"").append(jsonEscape(p.location)).append("\"")
                .append("}, \"results\”: [");
        for (int i = 0; i < recs.size(); i++) {
            RecommenderService.Scored rs = recs.get(i);
            Scheme s = rs.scheme;
            int score = rs.score;
            sb.append("{")
                    .append("\"id\”: \"").append(jsonEscape(s.id)).append("\",")
                    .append("\"name\”: \"").append(jsonEscape(s.name)).append("\",")
                  .append("\"ministry\”:\"").append(jsonEscape(s.ministry)).append("\",")
               .append("\"summary\":\"").append(jsonEscape(s.summary)).append("\",")
                   .append("\"benefits\":\"").append(jsonEscape(s.benefits)).append("\",")
                    .append("\"link\”: \"").append(jsonEscape(s.link)).append("\",")
                    .append("\"score\":").append(score)
                    .append("}");
            if (i < recs.size() - 1) sb.append(",");
        }
        sb.append("]}");
        return sb.toString();
}
