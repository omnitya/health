package jha.abhishek.healthrestendpoints;

import org.neo4j.driver.v1.*;

import static org.neo4j.driver.v1.Values.parameters;

public class BlankSandbox {

    public static void main(String...args) {
        Config noSSL = Config.build().withEncryptionLevel(Config.EncryptionLevel.NONE).toConfig();
        Driver driver = GraphDatabase.driver("bolt://54.87.158.128:34089",AuthTokens.basic("neo4j","posts-port-braid"),noSSL); // <password>
        try (Session session = driver.session()) {
            String query = Neo4jQueryBuilderUtil.matchAttribute("50024");
            /*String cypherQuery =
                    "MATCH (n) " +
                            "RETURN n.name AS name";*/
            StatementResult result = session.run(query, parameters());
            while (result.hasNext()) {
                System.out.println(result.next().get("name"));
            }
        }
    }
}


