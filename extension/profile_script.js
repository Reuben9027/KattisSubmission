import {OwnerString, RepoString, TokenString,ProfileString,
    AcceptedString, CompileErrorString, MemoryLimitString,RunTimeString,TimeLimitString,
    WrongAnswerString,
} from './storage.js';


localStorage["c"+AcceptedString] = "rgba(51,186,80,255)";
localStorage["c"+WrongAnswerString]="rgba(232,79,103,255)";
localStorage["c"+TimeLimitString] = "rgba(243,183,77,255)";
localStorage["c"+MemoryLimitString] = "rgba(0,0,0,255)";
localStorage["c"+RunTimeString]= "rgba(117,169,212,255)";
localStorage["c" + CompileErrorString] = "rgba(196,90,156,255)";

var buttonLogin = document.getElementById("setProfileButton");
var buttonUpdate = document.getElementById("updateProfileButton");

var forms = document.getElementById("profile-form");
var ratio = {};


if(localStorage[ProfileString] != null||localStorage[ProfileString] != ""){
    forms.value = localStorage[ProfileString];
}

buttonLogin.onclick = () =>{
    if(localStorage[ProfileString]= null){
        localStorage[ProfileString] ="";
    }
    localStorage[ProfileString] = forms.value;
}

function name(params) {
    
}

buttonUpdate.onclick = async () =>{
    var link = localStorage[ProfileString];

    var linkSubmission = link+"?tab=submissions&page="
    var pageNumber = 0;



    const acceptedCounter = document.getElementById("accepted");
    const wrongCounter = document.getElementById("wrong");
    const tleCounter = document.getElementById("tle");

    while(true){
        try {
            const domParser = new DOMParser()
        
            var url = linkSubmission+pageNumber;
            const response = await fetch(url, {
            method: "GET",
            headers: {
                "User-Agent": "Mozilla/5.0" // Mimic a browser
            }
            });
            if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
            }
            const html = await response.text();
            
            var doc = domParser.parseFromString(html, "text/html");

            var submissions = doc.getElementById("submissions");
            var rowsSubmission = submissions.getElementsByTagName("tbody")[0].getElementsByTagName("tr");

            var len = rowsSubmission.length/2;

            //alert(len);
            for(var i = 0; i<len; i++){
                
                acceptedCounter.textContent = (ratio["Accepted"] ||"0") ; 
                wrongCounter.textContent =( ratio["Wrong Answer"] ||"0");
                tleCounter.textContent = (ratio["Time Limit Exceeded"] ||"0");
                try {    
                    const xmlhttp = new XMLHttpRequest();
                    var subId = rowsSubmission[i*2].getAttribute("data-submission-id");
                    var subIdKEY = "subKey_"+subId;
                    var judgement  = null;
                    if(localStorage[subIdKEY] == null){
                        var subLink ="https://open.kattis.com/api/unstable/submission/"+subId;
                        //json
                        var submissionJson = null;
                        xmlhttp.open("GET", subLink, false);
                        xmlhttp.send();
                        submissionJson = JSON.parse(xmlhttp.responseText);
                        judgement = submissionJson.judgement;
                        localStorage[subIdKEY] = judgement;
                    }else{
                        judgement = localStorage[subIdKEY];
                    }

                    if(ratio[judgement] == null){
                        ratio[judgement] =0;
                    }
                    ratio[judgement] ++;
                    // /alert(judgement);   
                } catch (error) {
                }
                console.log(ratio);
                // setTimeout(function() {
                //     //alert(judgement);
                //   }, 500); // 3 seconds
                //alert(judgement);
            }

            console.log(len);
            if(len !=100){
                break;
            }
        } catch (error) {
            alert(error);
            break;
        }
        pageNumber++;
    }


    // localStorage["c"+AcceptedString] = "rgba(51,186,80,255)";
    // localStorage["c"+WrongAnswerString]="rgba(232,79,103,255)";
    // localStorage["c"+TimeLimitString] = "rgba(243,183,77,255)";
    // localStorage["c"+MemoryLimitString] = "rgba(0,0,0,255)";
    // localStorage["c"+RunTimeString]= "rgba(117,169,212,255)";
    // localStorage["c" + CompileErrorString] = "rgba(196,90,156,255)";
    
    const jsonChart = {
        type: "pie",
        data: {
            labels:[AcceptedString,WrongAnswerString, TimeLimitString,
                MemoryLimitString,RunTimeString,CompileErrorString],
            datasets:[
                {
                    data:[ratio[AcceptedString] ,ratio[WrongAnswerString], 
                        ratio[TimeLimitString], ratio[MemoryLimitString],
                        ratio[RunTimeString], ratio[CompileErrorString]
                    ],
                    backgroundColor:[
                        localStorage["c"+AcceptedString] ,localStorage["c"+WrongAnswerString], 
                        localStorage["c"+TimeLimitString], localStorage["c"+MemoryLimitString],
                        localStorage["c"+RunTimeString], localStorage["c"+CompileErrorString]
                    ]
                }
            ]
        }
    }

    const jsonStringLink= "![](https://quickchart.io/chart?c="+encodeURIComponent(JSON.stringify(jsonChart))+")";


    // chrome.tabs.query({ active: true, currentWindow: true }, (tabs) => {
    //     if (tabs && tabs.length > 0) {
    //         var tabUrl = tabs[0].url;
    //         chrome.scripting.executeScript({
    //             target: { tabId: tabs[0].id },
    //             func: ( owner, token ,repo, tabUrl) => {
    try {
        const owner = localStorage[OwnerString];
        const token = localStorage[ TokenString];
        const repo =  localStorage[ RepoString];
        const currentDate = new Date();
        const formattedDate = `${currentDate.getFullYear()}-${String(currentDate.getMonth() + 1).padStart(2, '0')}-${String(currentDate.getDate()).padStart(2, '0')}`;
        console.log(formattedDate);
        //thanks chatgpt
        const urlGithub =  `https://api.github.com/repos/${owner}/${repo}/contents/profile/Profile-${formattedDate}.md`;
        const payload = {
            message: `Profile update ${formattedDate}`,  // Commit message
            content: btoa(jsonStringLink),     // Directly use the Base64 string  
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
        console.log(error);
    }                
    //             args: [ localStorage[OwnerString], localStorage[ TokenString], localStorage[ RepoString], tabUrl]
    //         }, (result) => {
    //             console.log('Script executed', result);
    //         });
    //     } else {
    //         console.error("No active tab found.");
    //     }
    // });
    console.log("DONE");

    alert(ratio);
    alert(localStorage[ProfileString]);
}

