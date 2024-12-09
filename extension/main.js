import { TokenString, OwnerString, RepoString} from './storage.js';
//import { upload} from './upload.js';



var button = document.getElementById("testButton");
var buttonLogin = document.getElementById("loginButton");


buttonLogin.onclick =() =>{
    //chrome.action.setPopup({ popup: "popup2.html" });
    try {
        window.location.href = "popup2.html"; // Immediately show Popup 2.
        return;   
    } catch (error) {
        
    }
}


    
button.onclick = () => {
    console.log("blin");

    //check if a repository is available
    try {
        var con = localStorage[TokenString] !="" && localStorage[OwnerString] !="" &&localStorage[RepoString] !="";
        if(!con){
            //chrome.action.setPopup({ popup: "popup2.html" });
            window.location.href = "popup2.html"; 
            return;
        }   
    } catch (error) {

    }

    try {
        chrome.tabs.query({ active: true, currentWindow: true }, (tabs) => {
            if (tabs && tabs.length > 0) {
                var tabUrl = tabs[0].url;
                chrome.scripting.executeScript({
                    target: { tabId: tabs[0].id },
                    func: ( owner, token ,repo, tabUrl) => {
                        try {
                            urlToken= tabUrl.split("/"); 
                            last = urlToken[urlToken.length -1];

                            var xmlhttp2 = new XMLHttpRequest();
                            var urlJson = tabUrl+ "?json=true";
                            xmlhttp2.open("GET", urlJson, false);
                            xmlhttp2.send();
                            var urlJsonData = JSON.parse(xmlhttp2.responseText);
                            var row = urlJsonData.row_html;
                            var hidden = document.createElement("table");
                            hidden.innerHTML = row;
                            var hiddenRows = hidden.rows[0].getElementsByTagName("td");
                            var date = hiddenRows[1].innerHTML;
                            var commitMessage = "Submission Date: "+date.split(" ")[0];
                            //alert(last);
                            
                            var url = "https://open.kattis.com/api/unstable/submission/"+ last;


                            var xmlhttp = new XMLHttpRequest();
                            var submissionJson = null;
                            xmlhttp.open("GET", url, false);
                            xmlhttp.send();
                            submissionJson = JSON.parse(xmlhttp.responseText);
                            var fileBase64 = submissionJson.files[0].data;
                            var problemId= submissionJson.problem_id;
                            var filename = submissionJson.files[0].filename;
                            // const importUpload = chrome.runtime.getURL('upload.js');
                            // const content =  import(importUpload);
                            // content.upload(fileBase64,"Blin");


                            //thanks chatgpt
                            const urlGithub =  `https://api.github.com/repos/${owner}/${repo}/contents/solutions/${problemId}/${filename}`;
                            const payload = {
                                message: commitMessage,  // Commit message
                                content: fileBase64,     // Directly use the Base64 string
                                branch: "main"           // Specify the branch (default is "main")
                            };
                            const response =  fetch(urlGithub, {
                                method: 'PUT',
                                headers: {
                                  'Authorization': `token ${token}`,
                                  'Content-Type': 'application/json',
                                },
                                body: JSON.stringify(payload)
                              });
                        
                            const result =  response.json();
                            if (response.ok) {
                                alert("Success");
                                console.log('File uploaded successfully:', result);
                            } else {
                                alert("Failed");
                                console.error('Error uploading file:', result);
                            }
                            } catch (error) {
                               // alert(error);
                            }                
                    },
                    args: [ localStorage[OwnerString], localStorage[ TokenString], localStorage[ RepoString], tabUrl]
                }, (result) => {
                    console.log('Script executed', result);
                });
            } else {
                console.error("No active tab found.");
            }
        });
        console.log("End");
    } catch (error) {
        console.log(error)
    }
}
