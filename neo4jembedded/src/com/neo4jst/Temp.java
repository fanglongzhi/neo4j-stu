package com.neo4jst;

/**
 * @program:
 * @description:
 * @author: zhifanglong
 * @create: 2019-12-16 15:27
 */
public class Temp {
    void Test(){
         /*Map<String,Object> node1 = new HashMap<>();
        node1.put("name","lisa");
        node1.put("label","Person");
        saveNode(db,MyLabels.Person,node1);

        node1.put("name","Ed");
        saveNode(db,MyLabels.Person,node1);

        node1.put("name","lars");
        saveNode(db,MyLabels.Person,node1);

        node1.put("name","Joe");
        saveNode(db,MyLabels.Person,node1);

        node1.put("name","Dirk");
        saveNode(db,MyLabels.Person,node1);

        node1.put("name","Peter");
        saveNode(db,MyLabels.Person,node1);

        node1.put("name","Sara");
        saveNode(db,MyLabels.Person,node1);

        Map<String,Object> rel = new HashMap<>();
        rel.put("name1","lisa");
        rel.put("name2","lars");
        saveRe(db,RelTypes.KNOWS,rel);

        rel.put("name2","Joe");
        saveRe(db,RelTypes.LIKES,rel);

        rel.put("name1","Ed");
        rel.put("name2","lars");
        saveRe(db,RelTypes.KNOWS,rel);

        rel.put("name1","Joe");
        rel.put("name2","Sara");
        saveRe(db,RelTypes.KNOWS,rel);

        rel.put("name1","Peter");
        saveRe(db,RelTypes.KNOWS,rel);

        rel.put("name1","lars");
        rel.put("name2","Dirk");
        saveRe(db,RelTypes.KNOWS,rel);

        rel.put("name1","Dirk");
        rel.put("name2","Peter");

        saveRe(db,RelTypes.KNOWS,rel);

*/
       /* Node TheMatrix;
        Node Keanu;
        Transaction tx = db.beginTx();
        try(tx)
        {
            TheMatrix=db.createNode();
            TheMatrix.setProperty("title","The Matrix");
            TheMatrix.setProperty("released",1999);
            TheMatrix.setProperty("tagline","Welcome to the Real World");
            TheMatrix.addLabel(MyLabels.Movie);

            Keanu=db.createNode();
            Keanu.setProperty("name","Keanu Reeves");
            Keanu.setProperty("born",1960);
            Keanu.addLabel(MyLabels.Person);

            Relationship ship =Keanu.createRelationshipTo(TheMatrix,RelTypes.ACTED_IN);
            ship.setProperty("roles","Neo");
            tx.success();
        }catch (Exception e){
            tx.failure();
        }finally {
            tx.close();
        }

        try(Transaction tx2 = db.beginTx()) {
            ResourceIterator<Node> persons = db.findNodes(MyLabels.Person);
            for (ResourceIterator<Node> it = persons; it.hasNext(); ) {
                Node n = it.next();

                System.out.println(n.getProperties("name","born"));


            }
            tx2.success();
        }*/
    }
}
