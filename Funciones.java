	// Funciones de Mapeo

// Enlistar las canciones x artista 

function (doc) {
  if(doc.artista){
    for(var i in doc.artista){
      emit(doc.artista[i],doc.title)
    }
  }
}


// Enlistar las canciones con su duracion 

function (doc) {
  emit(doc.title,doc.duracion);
}


// Enlistar la lista de Sencillos 

function (doc) {
  if(doc.album.indexOf("Sencillo")>-1){
    emit(doc.title,doc.duracion);
  }
}


// Enlistar todas las canciones del ultimo año en especifico 
// Reduce Function _sum() para contabilizar las canciones de ese año

function (doc) {
  var añoReferencia = new Date("2020");
  if(new Date(doc.año) >= añoReferencia){
    emit(doc.title,1);  
  }
}


// Reduce Function _count()
// Contabilizar cuantas canciones existen del mismo año
function (doc) {
  emit(doc.año,1);
}
