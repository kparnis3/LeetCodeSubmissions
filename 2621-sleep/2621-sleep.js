/**
 * @param {number} millis
 */
async function sleep(millis) {
    
    //First way
    /*
    function callback(resolve, reject){
        setTimeout(resolve, millis);
    }
    
    return new Promise(callback);
    */
    
    //Second way
    await new Promise((resolve,reject) =>{
        setTimeout(resolve, millis);
    })
    
}

/** 
 * let t = Date.now()
 * sleep(100).then(() => console.log(Date.now() - t)) // 100
 */