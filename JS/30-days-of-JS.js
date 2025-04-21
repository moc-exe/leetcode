// (1)
// Hello World function
// https://leetcode.com/problems/create-hello-world-function/description/?envType=study-plan-v2&envId=30-days-of-javascript

/**
 * @return {Function}
 */
var createHelloWorld = function() {
    
    return function(...args) {
        return "Hello World";
    }
};


// (2)
// Counter
// https://leetcode.com/problems/counter/submissions/1591458655/?envType=study-plan-v2&envId=30-days-of-javascript

/**
 * @param {number} n
 * @return {Function} counter
 */
var createCounter = function(n) {
    
    return function() {
    
        let count = n;
        return n++;

    };
};

// (3)
// To Be or Not to Be 
// https://leetcode.com/problems/to-be-or-not-to-be/?envType=study-plan-v2&envId=30-days-of-javascript

/**
 * @param {string} val
 * @return {Object}
 */
var expect = function(val){

    let toTest = {

        notToBe : (other) => {

            if(other !== val){
                return true;
            }
            throw new Error("Equal");
        
        },
        toBe : (other) => {

            if(other === val){
                return true;
            }
            throw new Error("Not Equal");
        }
    };

    return toTest;
    
};

// (4)
// Counter II
// https://leetcode.com/problems/counter-ii/description/?envType=study-plan-v2&envId=30-days-of-javascript

/**
 * @param {integer} init
 * @return { increment: Function, decrement: Function, reset: Function }
 */
var createCounter = function(init) {

    let counter = {

        count : init,
        countInit : init,
        increment : function () { counter.count++; return counter.count; },
        decrement : function () { counter.count--; return counter.count; }, 
        reset : function () { counter.count = counter.countInit; return counter.count;}
    };

    return counter;
};


// (5)
// Apply Transform Over Each Element in Array
// https://leetcode.com/problems/apply-transform-over-each-element-in-array/description/?envType=study-plan-v2&envId=30-days-of-javascript

/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
var map = function(arr, fn) {
    return arr.map(fn);
};

// (6)
//  2634. Filter Elements from Array
// https://leetcode.com/problems/filter-elements-from-array/description/?envType=study-plan-v2&envId=30-days-of-javascript

/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
var filter = function(arr, fn){

    return arr.filter(fn);
};


// (7)
// 2626. Array Reduce Transformation
// https://leetcode.com/problems/array-reduce-transformation/description/?envType=study-plan-v2&envId=30-days-of-javascript
/**
 * @param {number[]} nums
 * @param {Function} fn
 * @param {number} init
 * @return {number}
 */
var reduce = function(nums, fn, init) {
    return nums.reduce(fn, init)
};

// (8)
// 2629. Function Composition
// https://leetcode.com/problems/function-composition/description/?envType=study-plan-v2&envId=30-days-of-javascript

/**
 * @param {Function[]} functions
 * @return {Function}
 */
var compose = function(functions) {
    
    return function(x) {

        let currVal = x;

        for (let i = functions.length - 1; i >= 0; i--){

            let currFunc = functions[i];
            currVal = currFunc(currVal);
        }

        return currVal;
    }
};




// (9)
// 2703. Return Length of Arguments Passed
// https://leetcode.com/problems/return-length-of-arguments-passed/description/?envType=study-plan-v2&envId=30-days-of-javascript

var argumentsLength = function(...args) {
    return args.length
};

// (9)
// 2666. Allow One Function Call
// https://leetcode.com/problems/allow-one-function-call/description/?envType=study-plan-v2&envId=30-days-of-javascript

/**
 * @param {Function} fn
 * @return {Function}
 */
var once = function(fn) {
    
    let count = 0;

    return function(...args){
        count++;
        if (count == 1){
            return fn(...args);
        } 
    }
};

// (10)
// 2623. Memoize
// https://leetcode.com/problems/memoize/description/?envType=study-plan-v2&envId=30-days-of-javascript

/**
 * @param {Function} fn
 * @return {Function}
 */
function memoize(fn){
    
    const hashMap = new Map();

    return function(...args) {
    
        let argString = JSON.stringify(args);

        if(hashMap.has(argString)){
            return hashMap.get(argString);
        }
        else{
            let out = fn(...args);
            hashMap.set(argString, out);
            return out;
        }
    }
}




// (11)
// 2723. Add Two Promises
// https://leetcode.com/problems/add-two-promises/?envType=study-plan-v2&envId=30-days-of-javascript 

/**
 * @param {Promise} promise1
* @param {Promise} promise2
* @return {Promise}
*/

var addTwoPromises = async function(promise1, promise2) {
   
    return new Promise(async (resolve, reject) => {

        let first = await promise1;
        let second = await promise2;
        resolve(first + second);

    })

};



// (12)
// 2621. Sleep
// https://leetcode.com/problems/sleep/?envType=study-plan-v2&envId=30-days-of-javascript

/**
 * @param {number} millis
 * @return {Promise}
 */
async function sleep(millis) {
    return new Promise((resolve) => { setTimeout(resolve, millis); });
}

/** 
 * let t = Date.now()
 * sleep(100).then(() => console.log(Date.now() - t)) // 100
 */


// (13)
// 2715. Timeout Cancellation
// https://leetcode.com/problems/timeout-cancellation/description/?envType=study-plan-v2&envId=30-days-of-javascript


/**
 * @param {Function} fn
 * @param {Array} args
 * @param {number} t
 * @return {Function}
 */
var cancellable = function(fn, args, t){
   
    let timer = setTimeout(() => {
        fn(...args);
    }, t);

    return function() {
        clearTimeout(timer);
    }
};

/**
 *  const result = [];
 *
 *  const fn = (x) => x * 5;
 *  const args = [2], t = 20, cancelTimeMs = 50;
 *
 *  const start = performance.now();
 *
 *  const log = (...argsArr) => {
 *      const diff = Math.floor(performance.now() - start);
 *      result.push({"time": diff, "returned": fn(...argsArr)});
 *  }
 *       
 *  const cancel = cancellable(log, args, t);
 *
 *  const maxT = Math.max(t, cancelTimeMs);
 *           
 *  setTimeout(cancel, cancelTimeMs);
 *
 *  setTimeout(() => {
 *      console.log(result); // [{"time":20,"returned":10}]
 *  }, maxT + 15)
 */



// (14) 
// 2637. Promise Time Limit
// https://leetcode.com/problems/promise-time-limit/description/?envType=study-plan-v2&envId=30-days-of-javascript

/**
 * @param {Function} fn
 * @param {number} t
 * @return {Function}
 */
var timeLimit = function(fn, t) {
    

    
    return async function(...args) {
     
        return new Promise((resolve, reject) => {

            let timeoutId = setTimeout(reject, t, "Time Limit Exceeded");

            let out = fn(...args)
                .then((val) => {

                    clearTimeout(timeoutId);
                    resolve(val);
                })
                .catch((err) =>{

                    clearTimeout(timeoutId);
                    reject(err);
                })

        })
    }
};

/**
 * const limited = timeLimit((t) => new Promise(res => setTimeout(res, t)), 100);
 * limited(150).catch(console.log) // "Time Limit Exceeded" at t=100ms
 */
