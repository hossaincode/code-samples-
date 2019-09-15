import React,{Component} from 'react';

import './App.css';

class App extends Component{
  constructor(props){
    super(props);
    this.state={
      title:`Simple react Application `,
      act:0,
      index:'',
      datas:[]

    }
  }

componentDidMount(){

  
  this.refs.name.focus();
  
  
  
  

}
fsubmit=(e)=>{
  e.preventDefault();
  
  let datas =this.state.datas;
  let name1=this.refs.name.value;
  let street1 =this.refs.addressStreet.value;
  let apt1= this.refs.addressApt.value;
  let zip1= this.refs.addressZip.value;
  let city1= this.refs.addressCity.value;
  let country1=this.refs.addressCountry.value;
  if(this.state.act===0){
    let data={
      name1,street1,apt1,zip1,city1,country1
    }
    datas.push(data);
  }
else{
  let index= this.state.index;
  datas[index].name1=name1;
  datas[index].street1=street1;
  datas[index].apt1=apt1;
  datas[index].zip1=zip1;
  datas[index].city1=city1;
  datas[index].country1=country1;
}
  
 
  this.setState({
    datas:datas
  });
  
  this.refs.myform.reset();
  this.refs.name.focus();
}
fedit=(i)=>{
  
  let data1= this.state.datas[i];
  
  this.refs.name.value=data1.name1;
  this.refs.addressStreet.value=data1.street1;
  this.refs.addressApt.value= data1.apt1;
  this.refs.addressZip.value=data1.zip1;
  this.refs.addressCity.value=data1.city1;
  this.refs.addressCountry.value=data1.country1;

  this.refs.name.focus();
  this.setState({
    act:1,
    index:i
  })

}
fdelete=(i)=>{
  let datas =this.state.datas;
  
  
  datas.splice(i,1);
  


  this.setState({
    datas:datas
  })
  
  this.refs.myform.reset();
  this.refs.name.focus();
}
renderTableData() {
  let datas= this.state.datas;
  return datas.map((data1, index) => {
     const { name1,street1,apt1,zip1,city1,country1} = data1 //destructuring
     return (
        <tr key={index +1}>
           
           <td>{name1}</td>
           
           <td>{street1}</td>
           <td>{apt1}</td>
           <td>{zip1}</td>
           <td>{city1}</td>
           <td>{country1}</td>
           <td></td>
           <td><button onClick={()=>this.fedit(index)} className="btn  btn-warning m-2">Edit</button>
            <button onClick={()=>this.fdelete(index)} className="btn btn btn-danger m-2">Delete</button></td>
        </tr>
     )
  })
}
renderTableHeader() {
  let header = ['name ','Street','Apt','Zip','City','Country']
  return header.map((key, index) => {
     return <th key={index+1}>{key.toUpperCase()}</th>
  })
}


render(){
  
  return (
    <div className="App">

        <h2 className="text-center">{this.state.title}</h2>
        <form ref="myform" className="form-group">
          <input type="text" ref="name" placeholder="Your Name " className="form-control"/>    
          <input type="text" ref="addressStreet" placeholder="Enter  Street Address here " className="form-control"/>
          <input type="text" ref="addressApt" placeholder="Enter  Apt no Here" className="form-control"/>
          <input type="text" ref="addressZip" placeholder="Enter Zip" pattern="[0-9]{5}" title="Five digit zip code" className="form-control"/>
          <input type="text" ref="addressCity" placeholder="Enter  City Name " className="form-control"/>
          <input type="text" ref="addressCountry" placeholder="Enter  Country Name " className="form-control"/>
          <button onClick={(e)=>this.fsubmit(e)} className="btn btn-primary btn-block">Add Adress</button>

        </form>
        <pre>
        <div>
            <p id='title'>User Address book </p>
            <table class=" table table-stripped mt-5">
               <tbody>
               <tr>{this.renderTableHeader()}</tr>
                  {this.renderTableData()}
               </tbody>
            </table>
         </div>

        </pre>
      
    </div>
  );

}
 

}

export default App;
