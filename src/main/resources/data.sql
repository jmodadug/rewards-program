INSERT INTO "CUSTOMER"("CUSTOMER_ID","CREATED_TIMESTAMP","UPDATED_TIMESTAMP","CUSTOMER_NAME")VALUES(1,sysdate,sysdate,'jayakrishna'),(2,sysdate,sysdate,'modadugu');
insert into transaction (created_timestamp, product_cost, product_name, reward_points, transaction_date, updated_timestamp, customer_id, id) values 
(sysdate, 192,'Product1' ,234, parsedatetime('17-09-2019 18:47:52.690', 'dd-MM-yyyy hh:mm:ss.SS'), sysdate, 1,  (SELECT NEXT VALUE FOR hibernate_sequence)),
(sysdate, 59,'Product2' ,9, parsedatetime('18-09-2019 18:47:52.690', 'dd-MM-yyyy hh:mm:ss.SS'), sysdate, 1,  (SELECT NEXT VALUE FOR hibernate_sequence)),
(sysdate, 93,'Product3' ,43, parsedatetime('19-09-2019 18:47:52.690', 'dd-MM-yyyy hh:mm:ss.SS'), sysdate, 1,  (SELECT NEXT VALUE FOR hibernate_sequence)),
(sysdate, 112,'Product4' ,74, parsedatetime('17-10-2019 18:47:52.690', 'dd-MM-yyyy hh:mm:ss.SS'), sysdate, 1,  (SELECT NEXT VALUE FOR hibernate_sequence)),
(sysdate, 156,'Product5' ,162, parsedatetime('20-10-2019 18:47:52.690', 'dd-MM-yyyy hh:mm:ss.SS'), sysdate, 1,  (SELECT NEXT VALUE FOR hibernate_sequence)),
(sysdate, 62,'Product6' ,15, parsedatetime('21-10-2019 18:47:52.690', 'dd-MM-yyyy hh:mm:ss.SS'), sysdate, 1,  (SELECT NEXT VALUE FOR hibernate_sequence)),
(sysdate, 95,'Product7' ,45, parsedatetime('22-11-2019 18:47:52.690', 'dd-MM-yyyy hh:mm:ss.SS'), sysdate, 1,  (SELECT NEXT VALUE FOR hibernate_sequence)),
(sysdate, 172,'Product8' ,194, parsedatetime('23-11-2019 18:47:52.690', 'dd-MM-yyyy hh:mm:ss.SS'), sysdate, 1,  (SELECT NEXT VALUE FOR hibernate_sequence)),
(sysdate, 12,'Product9' ,0, parsedatetime('15-11-2019 18:47:52.690', 'dd-MM-yyyy hh:mm:ss.SS'), sysdate, 1,  (SELECT NEXT VALUE FOR hibernate_sequence));