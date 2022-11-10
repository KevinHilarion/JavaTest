//Letras
function SoloLetras(e)
{
key = e.keyCode || e.which;
tecla = String.fromCharCode(key).toString();
letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZÁÉÍÓÚabcdefghijklmnopqrstuvwxyzáéíóú ";

especiales = [08,13];
tecla_especial = false
for(var i in especiales) {
if(key == especiales[i]){
 tecla_especial = true;
 break;
}
}

if(letras.indexOf(tecla) == -1 && !tecla_especial)
{
	
 sweetAlert("Lo siento...", "Solo se permiten letras!", "error");
  

 return false;
}
}


//Solo números
function SoloNumeros(evt)
{
if(window.event){
keynum = evt.keyCode;
}
else{
keynum = evt.which;
}

if((keynum > 47 && keynum < 58) || keynum == 8 || keynum== 13 )
{
return true;
}
else
{
sweetAlert("Lo siento...", "Solo se permiten números!", "error");
return false;
}
}


//Correo
document.getElementById('email').addEventListener('input', function() {
  campo = Event.target;
  valido = document.getElementById('emailOK');
      
  emailRegex = /^[-\w.%+]{1,64}@(?:[A-Z0-9-]{1,63}\.){1,125}[A-Z]{2,63}$/i;
  //Se muestra un texto a modo de ejemplo, luego va a ser un icono
  if (emailRegex.test(campo.value)) {
    valido.innerText = "válido";
  } else {
    valido.innerText = "incorrecto";
  }
});




//enviar formulario con la tecla ENTER
function enterEnviar(event){
    if(event.keyCode == 13){
      validarContraseña()
    }
}

//Ckeckbox




