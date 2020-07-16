package jha.abhishek.healthrestendpoints;

import java.util.Map;

/**
 * @author omnity.jha
 *
 * This class contains utility methods for neo4j query Builder.
 */
public class Neo4jQueryBuilderUtil {

    /**
     * This method builds query to match a given attribute;
     * @param attribute
     * @return
     */
    public static String matchAttribute(String attribute){
        StringBuilder query = new StringBuilder();
        query.append("MATCH (n)");
        query.append("WHERE ID(n)=");
        query.append(attribute);
        query.append(" RETURN n.name AS name");

        return  query.toString();
    }

    /**
     * This method builds query to return the 2 nodes having given edge property.
     * @param node1
     * @param node2
     * @param edge
     * @return
     */
    public static String matchTwoNodesWithEdge(String node1, String node2, String edge){
        StringBuilder query = new StringBuilder();
        query.append("MATCH (p:");
        query.append(node1);
        query.append("), (t:");
        query.append(node2);
        query.append(") WHERE (p)<-[:");
        query.append(edge);
        query.append("]-(t) OR (p)-[:");
        query.append(edge);
        query.append("]->(t)");
        query.append(" RETURN p,t");

        return query.toString();
    }

    /**
     * This method builds query to return the 3 nodes having given edge property.
     * @param node1
     * @param node2
     * @param node3
     * @param edge
     * @return
     */
    public static String matchThreeNodesWithEdge(String node1, String node2, String node3, String edge){
        StringBuilder query = new StringBuilder();
        query.append("MATCH (p:");
        query.append(node1);
        query.append("), (t:");
        query.append(node2);
        query.append("), (c:");
        query.append(node3);
        query.append("WHERE (p)<-[:");
        query.append(edge);
        query.append("]-(t) OR (p)-[:");
        query.append(edge);
        query.append("]->(t) AND (p)-[:");
        query.append(edge);
        query.append("]->(c)");
        query.append(" RETURN p,t,c");

        return query.toString();
    }

    /**
     * This method builds query to detach edges and delete node with given id.
     * @param nodeId
     * @return
     */
    public static String detachDeleteNodeId(String nodeId){
        StringBuilder query = new StringBuilder();
        query.append("MATCH (n)");
        query.append(" WHERE ID(n) = ");
        query.append(nodeId);
        query.append("DETACH DELETE n");

        return query.toString();
    }

    /**
     * This method builds query to detach and delete a node, given the node name, node attribute and node attribute value.
     * @param node
     * @param nodeAttribute
     * @param nodeAttrVal
     * @return
     */
    public static String detachDeleteNode(String node, String nodeAttribute, String nodeAttrVal){
        StringBuilder query = new StringBuilder();
        query.append("MATCH (n:");
        query.append(node);
        query.append(") WHERE n.");
        query.append(nodeAttribute);
        query.append(" = ");
        query.append(nodeAttrVal);
        query.append("DETACH DELETE n");

        return query.toString();
    }

    /**
     * This method will create a node with the given set of properties in Map.
     * @param node
     * @param map
     * @return
     */
    public static String createFirstLevelNode(String node, Map map){

        StringBuilder query = new StringBuilder();
        query.append("CREATE (o:");
        query.append(node);
        if(!map.isEmpty()){
            query.append("{");
            map.forEach((k,v)->{
                query.append(k);
                query.append(":");
                query.append(v);
                query.append(",");
            });
            query.deleteCharAt(query.length() - 1);
            query.append("}");
        }
        query.append(")");

        return query.toString();
    }

    /**
     * This method creates a relationship between two given nodes.
     * @param node1
     * @param node2
     * @param edge
     * @return
     */
    public static String create2NodeRelationship(String node1, String node1NameValue, String node2, String node2NameValue, String edge){
        StringBuilder query = new StringBuilder();
        query.append("MATCH (a:");
        query.append(node1);
        query.append(" {name:'");
        query.append(node1NameValue);
        query.append("'}), (b:");
        query.append(node2);
        query.append(" {name:'");
        query.append(node2NameValue);
        query.append("'}) CREATE (a)-[:");
        query.append(edge);
        query.append("]->(b)");

        return query.toString();
    }

}
