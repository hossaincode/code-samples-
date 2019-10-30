const mysql=require('mysql'); //for mysql connection 
const express =require('express');// for Express server 
const fs = require("fs");
var app=express();
var bodyParser =require('body-parser');

app.use(bodyParser.json({limit: "50mb",}));
app.use(bodyParser.urlencoded({limit: "50mb", extended: true, parameterLimit:50000}));
app.use(express.json({limit: '50mb'}));
app.use(express.urlencoded({limit: '50mb',extended: true}));
app.use(express.static(__dirname + '/public'));
app.use(function(req, res, next) {
    res.header("Access-Control-Allow-Origin", "*");
    res.header("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
    res.header('Access-Control-Allow-Methods', 'PUT, POST, GET, DELETE, OPTIONS');
       next();
 });



mysqlConnection= mysql.createConnection(
    {
        host:'localhost',
        user:'root',
        password:',
        database:'ImageTesting'

    }
);
mysqlConnection.connect( (err)=>{
    if(!err){
        console.log('Db connection succeeded');
    }
    else{
        console.log('Connection Error'+JSON.stringify(err))
    }
})
 

app.listen(3001,()=>
    console.log('Express server is listenning at port 3001')
);
const outputfile = "output.png";
app.get('/Products',(req,res)=>{
    res.setHeader('Access-Control-Allow-Origin', 'http://localhost:4200');
    mysqlConnection.query('SELECT * FROM Product',(err,rows,field)=>{
        if(!err){
             
            res.json(rows);
            
        }
        else{
            console.log(err);
        }
    })
})
app.get('/Products/:id',(req,res)=>{
    res.setHeader('Access-Control-Allow-Origin', 'http://localhost:4200');
    mysqlConnection.query('SELECT * FROM Product WHERE Product_Id=?',[req.params.id], (err,rows,field)=>{
        if(!err){
            res.json(rows);
        }
        else{
            console.log(err);        }
    })
})
app.get('/Products/abc/:id',(req,res)=>{
    res.setHeader('Access-Control-Allow-Origin', 'http://localhost:4200');
    mysqlConnection.query('SELECT * FROM Product WHERE Product_Id=?', [req.params.id],(err,rows,field)=>{
        if(!err){
            
            res.json(rows[0].product_like);
        }
        else{
            console.log(err);     
           }
    })
})

app.delete('/Products/del/:id',(req,res)=>{
    res.setHeader('Access-Control-Allow-Origin', 'http://localhost:4200');
    mysqlConnection.query('DELETE  FROM Product WHERE Product_Id=?',[req.params.id], (err,rows,field)=>{
        if(!err){
           
           
        }
        else{

            console.log(err);    
            }
    })
    mysqlConnection.query('SELECT * FROM Product',(err,rows,field)=>{
        if(!err){
             
            res.json(rows);
            
        }
        else{
            console.log(err);
        }
    })

    
})

app.put('/Products/UPD/:id', (req, res)=>{
    
    mysqlConnection.query('Update  Product  SET product_like=product_like+1 where Product_Id=?',[req.params.id], (err,rows,field)=>{
        if(!err){
            
        }
        else{
            console.log(err);      
          }
    })
    mysqlConnection.query('SELECT * FROM Product WHERE Product_Id=?', [req.params.id],(err,rows,field)=>{
        if(!err){
            
            res.json(rows[0].product_like);
        }
        else{
            console.log(err);     
           }
    })


})
app.post('/Products/UPD/:id',(req,res)=>{
    console.log(req);
    mysqlConnection.query('Update  Product  SET product_like=product_like-1 where Product_Id=?',[req.params.id], (err,rows,field)=>{
        if(!err){
            
        }
        else{
            console.log(err);      
          }
    })
    mysqlConnection.query('SELECT * FROM Product WHERE Product_Id=?', [req.params.id],(err,rows,field)=>{
        if(!err){
            
            res.json(rows[0].product_like);
        }
        else{
            console.log(err);     
           }
    })



} )
