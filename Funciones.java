	// Funciones de Mapeo

// Enlistar las canciones x artista 
// Reduce Function _count para contar el numero de canciones que un artista tiene en la base 
function (doc) {
  if(doc.artista){
    for(var i in doc.artista){
      emit(doc.artista[i],doc.title)
    }
  }
}


// Enlistar las canciones con su duracion 
function (doc) {
	if(doc.title){
		emit(doc.title,doc.duracion);
	}
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
// Contabilizar cuantas canciones existen en un mismo año
function (doc) {
	if(doc.año){
  		emit(doc.año,1);
	}
}


// Enlistar las canciones en funcion del album al que pertenecen
// Reduce Function _cout() para contabilizar cuantas canciones existen del mismo album 
function (doc) {
  if((doc.album)!= "Sencillo"){
    emit(doc.album, doc.title);
  }
}


// Enlistar las canciones por su produccion 
// Reduce Function _count para contar el numero de canciones de un mismo productor 
function (doc) {
  if(doc.productor){
    for(var i in doc.productor){
      emit(doc.productor[i],doc.title)
    }
  }
}


// Enlistar las canciones por su genero
// Reduce Function _count para contar el numero de canciones de un mismo genero 
function (doc) {
	if(doc.genero){
		emit(doc.genero,doc.title);
	}
}


// Reduce Function _sum para 
// obtiene el numero de min que ha cantado o ha contribuido cada artista 
function (doc) {
  if(doc.artista){
    for(var i in doc.artista){
      emit(doc.artista[i],doc.duracion)
    }
  }
}


// Reduce Function _sum para 
// obtiene el numero de min que se tiene de un mismo album 
function (doc) {
  if(doc.album){
    emit(doc.album,doc.duracion)
  }
}