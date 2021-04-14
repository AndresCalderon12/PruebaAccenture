# Tecnologias

El proyecto fue creado usando Java 1.8, SpringBoot 2.0.1

# EndPoint y JSONS de prueba

estos EndPoints fueron probados haciendo uso del software PostMan
localhost:8089/payments/order
{
    "tpyeIdBuyer":"36",
    "IdBuyer":"1077974701",
    "direction":"prueba",
    "products":[
        {
            "productName": "Prueba",
            "price":50000
        },
        {
            "productName": "Prueba2",
            "price":20000 
        }
    ]
}
localhost:8089/payments/deleteorder?idBill=1

localhost:8089/payments/editorder?idBill=1
{
    "tpyeIdBuyer":"36",
    "IdBuyer":"1077974701",
    "direction":"prueba",
    "products":[
        {
            "productName": "Prueba3",
            "price":90000
        },
        {
            "productName": "Prueba4",
            "price":50000 
        }
    ]
}


