package jha.abhishek.healthrestendpoints;

/**
 * @author omnity.jha
 */
public class Neo4jQueryUtil {

    /**
     * This method builds query to match a given attribute;
     * @param attribute
     * @return
     */
    public String matchAttribute(String attribute){
        StringBuilder query = new StringBuilder();
        query.append("MATCH (n)");
        query.append("WHERE ID(n)=");
        query.append(attribute);
        query.append(" RETURN n");

        return  query.toString();
    }

    /**
     * This method builds query to return the 2 nodes having given edge property.
     * @param node1
     * @param node2
     * @param edge
     * @return
     */
    public String matchTwoNodesWithEdge(String node1, String node2, String edge){
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
    public String matchThreeNodesWithEdge(String node1, String node2, String node3, String edge){
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
    public String detachDeleteNodeId(String nodeId){
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
    public String detachDeleteNode(String node, String nodeAttribute, String nodeAttrVal){
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

}
