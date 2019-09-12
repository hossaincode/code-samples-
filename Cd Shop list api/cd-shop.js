class CD{
    constructor(title,artist,type,genre){
        this.title= title;
        this.artist=artist;
        this.type=type;
        this.genre=genre;
        

    }

}
class Store{
   static  getCDs(){
       let cds;
       if(localStorage.getItem('cds')===null){
           cds=[];
       }
       else{
           cds=JSON.parse(localStorage.getItem('cds'));
       }
       return cds;
    }
    static addCDs(cd){
        const cds=Store.getCDs();
        cds.push(cd);
        localStorage.setItem('cds',JSON.stringify(cds));

    }
    static removeCDs(ttl){
        const cds= Store.getCDs();
        cds.forEach( (cd,index)=>{
           
                
               if(cd.title.trim() ===ttl.trim()){
                   cds.splice(index,1);
               }
                
            }
            
        )
        localStorage.setItem('cds',JSON.stringify(cds));

    }
    

}

class UI{

    static displaycds(){
        
        const cds =Store.getCDs();
        cds.forEach((cd)=> UI.addCDToList(cd));
     }
     static addCDToList(cd){
         const list= document.querySelector('.cd-list');
         const row =document.createElement('tr');
         row.innerHTML=`
         <td> ${cd.title}</td>
         <td> ${cd.artist}</td>
         <td> ${cd.type}</td>
         <td>${cd.genre}</td>
         <td><a href="#" class= "btn btn-danger btn-sm delete">X</a></td>
         
         `;
         list.appendChild(row);
     }
     static deleteCDs(element ){
         if(element.classList.contains('delete')){
             element.parentElement.parentElement.remove();
             
            
           
            UI.showAlert('Book Deleted','danger');
             
         }

     }
     static showAlert(message,className){
          const div= document.createElement('div');
          div.className= `alert alert-${className}`;
          div.appendChild(document.createTextNode(message));
          const container =document.querySelector('.container');
          const fom =document.querySelector('#cd-shop1');
         //console.log(container);
          container.insertBefore(div,fom);
          setTimeout(()=> document.querySelector('.alert').remove(), 1500);

     }
     static clearfields(){
        document.querySelector('#title').value='';

        document.querySelector('#artist').value='';
        document.querySelector('#type').value='';
        document.querySelector('#genre ').value='Jazz';
     }
     

}
document.addEventListener('DOMContentLoaded',UI.displaycds);
document.querySelector('#cd-shop1').addEventListener('submit',(e)=>{
    e.preventDefault();
    const title=document.querySelector('#title').value;
    const artist= document.querySelector('#artist').value;
    const  type=document.querySelector('#type').value;
    const genre=document.querySelector('#genre ').value;
    if(title===''|| artist===''|| type===''|| genre===''){
       UI.showAlert('please fill out all the box','danger');
    }
    else{
        const cd=  new CD(title,artist,type,genre);
        UI.addCDToList(cd);
        Store.addCDs(cd);
        UI.showAlert('Successfully inserted ','success');
        UI.clearfields();
       
        
    }

     
});
//console.log(Store.getCDs());

document.querySelector('.cd-list').addEventListener('click',(e)=>  {

    console.log(e.target);
    let key =e.target.parentElement.previousElementSibling.previousElementSibling.previousElementSibling.previousElementSibling.textContent;
   // console.log(key);
    UI.deleteCDs(e.target);
    Store.removeCDs(key);
})