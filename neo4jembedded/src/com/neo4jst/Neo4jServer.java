package com.neo4jst;

import org.neo4j.driver.*;
import org.neo4j.graphdb.*;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.neo4j.graphdb.traversal.Evaluators;

import java.io.File;
import java.util.Map;
/**
 * @program:
 * @description:
 * @author: zhifanglong
 * @create: 2019-12-16 10:07
 */
public class Neo4jServer {
    private static String DB_PATH="C:\\eli_task\\AI\\neodb";

    public static void main(String[] args){
        Driver driver = GraphDatabase.driver("bolt://localhost:7687", AuthTokens.basic("neo4j","neo4j123"));

        try(Session session = driver.session()){
            try(org.neo4j.driver.Transaction tx = session.beginTransaction()){
                 org.neo4j.driver.Result result = tx.run("MATCH (a:Member) RETURN a.gender as gender,a.name as name");
                 while(result.hasNext()){
                     Record record=result.next();
                     System.out.println(String.format("%s %s",record.get("gender").asString(),record.get("name").asString()));
                 }
            }
        }

        driver.close();

    }

    private static void embeddedServerExample(){
        GraphDatabaseService db=startServer();
        String output="";
        try(Transaction tx=db.beginTx()) {
            ResourceIterator<Node> persons = db.findNodes(MyLabels.Person);
            for (ResourceIterator<Node> it = persons; it.hasNext(); ) {
                Node n = it.next();

                System.out.print(n.getId()+":"+n.getProperties("name")+";");

            }
            for (Path position : db.traversalDescription()
                    .depthFirst()
                    .relationships(RelTypes.KNOWS)
                    .relationships(RelTypes.LIKES, Direction.INCOMING)
                    .evaluator(Evaluators.toDepth(3))
                    .traverse(db.findNode(MyLabels.Person, "name", "Joe")
                    )
            ) {
                output += position + "\n";
            }

            tx.success();
        }

        System.out.println(output);

    }
    private static void saveNode(GraphDatabaseService db, MyLabels label,Map<String,Object> param){
        try(Transaction tx = db.beginTx()) {
            Node pnode=db.findNode(MyLabels.Person,"name",param.get("name"));
            if(pnode==null) {
                db.execute("create(n:"+label.name()+" {name:$name})", param);
            }else{
                System.out.println("name::"+param.get("name")+" exist");
            }
            tx.success();
        }
    }

    private static void saveRe(GraphDatabaseService db, RelTypes type,Map<String,Object> param){
        try(Transaction tx = db.beginTx()) {

            db.execute("match (a:Person {name:$name1}),(b:Person {name:$name2}) "+
                    "create(a)-[:"+type.name()+"]->(b)", param);

            tx.success();
        }
    }
    private static GraphDatabaseService startServer(){
        GraphDatabaseService db=new GraphDatabaseFactory().newEmbeddedDatabase(new File(DB_PATH));
        registerShutdownHook(db);
        return db;
    }
    private static void registerShutdownHook(final GraphDatabaseService db){
        Runtime.getRuntime().addShutdownHook(new Thread(){
            @Override
            public void run() {
                db.shutdown();
            }
        });
    }
}
