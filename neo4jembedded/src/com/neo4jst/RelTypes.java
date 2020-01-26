package com.neo4jst;

import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.RelationshipType;

/**
 * @program: RelTypes
 * @description:
 * @author: zhifanglong
 * @create: 2019-12-13 11:22
 */
public enum RelTypes implements RelationshipType{
    ACTED_IN,
    DIRECTED,
    PRODUCED,
    KNOWS,
    LIKES
}
