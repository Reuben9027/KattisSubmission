
import { TokenString, OwnerString, RepoString,
    migrateLocalStorageToChromeStorage,
    token, owner,repo

 } from './storage.js';

var loginEnter = document.getElementById("loginEnter");
var tokenForm = document.getElementById("tokenForm");
var ownerForm = document.getElementById("ownerForm");
var repoForm = document.getElementById("repoForm");


if( localStorage[TokenString] == null){
    localStorage[TokenString] = "";
    localStorage[OwnerString] = "";
    localStorage[RepoStringz] ="";
}

loginEnter.onclick = () => {
    localStorage[TokenString] = tokenForm.value;
    localStorage[OwnerString] =   ownerForm.value;
    localStorage[RepoString] = repoForm.value; 
}