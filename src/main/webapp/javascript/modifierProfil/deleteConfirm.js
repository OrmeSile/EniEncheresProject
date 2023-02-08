const deleteButton = document.querySelector(".delete");
deleteButton.addEventListener('click', () =>{
    if(window.confirm("Voulez-vous supprimer votre compte ?")) {
        window.location.replace(context + "/profil/modifier/supprimer")
    }
})