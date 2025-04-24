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


// (15) 
// 2622. Cache With Time Limit
// https://leetcode.com/problems/cache-with-time-limit/description/?envType=study-plan-v2&envId=30-days-of-javascript

var TimeLimitedCache = function() {

    this.hashMap = new Map();

};

/** 
 * @param {number} key
 * @param {number} value
 * @param {number} duration time until expiration in ms
 * @return {boolean} if un-expired key already existed
 */
TimeLimitedCache.prototype.set = function(key, value, duration) {
    
    let out = this.hashMap.has(key) ? true : false;
    
    if(out){

        let timeoutId = this.hashMap.get(key).timeoutKey;
        clearTimeout(timeoutId);
        this.hashMap.set(key, {val: value, timeoutKey: setTimeout(() => this.hashMap.delete(key), duration)});
    }   
    else{
        this.hashMap.set(key, {val: value, timeoutKey: setTimeout(() => this.hashMap.delete(key), duration)});
    }
    return out;
};

/** 
 * @param {number} key
 * @return {number} value associated with key
 */
TimeLimitedCache.prototype.get = function(key) {
    return this.hashMap.has(key) ? this.hashMap.get(key).val : -1;
};

/** 
 * @return {number} count of non-expired keys
 */
TimeLimitedCache.prototype.count = function() {
    return this.hashMap.size;
};

/**
 * const timeLimitedCache = new TimeLimitedCache()
 * timeLimitedCache.set(1, 42, 1000); // false
 * timeLimitedCache.get(1) // 42
 * timeLimitedCache.count() // 1
 */


// (16) 
// 2627. Debounce
// https://leetcode.com/problems/debounce/description/?envType=study-plan-v2&envId=30-days-of-javascript

/**
 * @param {Function} fn
 * @param {number} t milliseconds
 * @return {Function}
 */
var debounce = function(fn, t) {
    
    let timeoutId = null;

    return function(...args){

        if(timeoutId !== null){

            clearTimeout(timeoutId);
        }
        
        timeoutId = setTimeout(fn, t, ...args);
        
    }
};

/**
 * const log = debounce(console.log, 100);
 * log('Hello'); // cancelled
 * log('Hello'); // cancelled
 * log('Hello'); // Logged at t=100ms
 */

// (17)
//  2721. Execute Asynchronous Functions in Parallel
// https://leetcode.com/problems/execute-asynchronous-functions-in-parallel/description/?envType=study-plan-v2&envId=30-days-of-javascript

/**
 * @param {Array<Function>} functions
 * @return {Promise<any>}
 */
var promiseAll = async function(functions) {
    return new Promise((resolve, reject) => {
        let outArray = new Array(functions.length);
        let resolvedCount = 0;

        for (let index = 0; index < functions.length; index++) {
            functions[index]()
                .then(res => {
                    outArray[index] = res;
                    resolvedCount++;

                    if (resolvedCount === functions.length) {
                        resolve(outArray);
                    }
                })
                .catch(err => reject(err));
        }
        if (functions.length === 0) {
            resolve(outArray);
        }
    });
};

/**
 * const promise = promiseAll([() => new Promise(res => res(42))])
 * promise.then(console.log); // [42]
 */

// (18)
// 2727. Is Object Empty
// https://leetcode.com/problems/is-object-empty/?envType=study-plan-v2&envId=30-days-of-javascript
/**
 * @param {Object|Array} obj
 * @return {boolean}
 */
var isEmpty = function(obj) {

    if(Array.isArray(obj)){
        return obj.length == 0;
    }
    else{
        return Object.keys(obj).length == 0 ? true : false;
    }
    
};


// (19)
// 2677. Chunk Array
// https://leetcode.com/problems/chunk-array/description/?envType=study-plan-v2&envId=30-days-of-javascript
/**
 * @param {Array} arr
 * @param {number} size
 * @return {Array}
 */
var chunk = function(arr, size) {
    
    let mainArray = []
    let counter = 0;
    let currArray = []
    for(var elem of arr){

        counter++;
        currArray.push(elem);
        if(counter == size){

            mainArray.push(currArray);
            counter = 0;
            currArray = [];
        }

    }

    if (currArray.length != 0){
        mainArray.push(currArray);
    }

    return mainArray;
};

// (20)
// 2619. Array Prototype Last
// https://leetcode.com/problems/array-prototype-last/description/?envType=study-plan-v2&envId=30-days-of-javascript
/**
 * @return {null|boolean|number|string|Array|Object}
 */
Array.prototype.last = function() {
    return this.length == 0 ? -1 : this.pop();
};

/**
 * const arr = [1, 2, 3];
 * arr.last(); // 3
 */


// (21)
// 2631. Group By
// https://leetcode.com/problems/group-by/?envType=study-plan-v2&envId=30-days-of-javascript

/**
 * @param {Function} fn
 * @return {Object}
 */
Array.prototype.groupBy = function(fn) {
    
    let outObj = {};

    for(let val of this.values()){

        let result = fn(val);
        
        if(outObj.hasOwnProperty(result)){
            outObj[result].push(val);
        }
        else{
            outObj[result] = []
            outObj[result].push(val);
        }
    }

    return outObj;
};

/**
 * [1,2,3].groupBy(String) // {"1":[1],"2":[2],"3":[3]}
 */


// (22)
// 2724. Sort By
// https://leetcode.com/problems/sort-by/?envType=study-plan-v2&envId=30-days-of-javascript


/**
 * @param {Array} arr
 * @param {Function} fn
 * @return {Array}
 */
var sortBy = function(arr, fn) {

   return arr.sort((a,b) => fn(a) - fn(b));

};

// (23)
// 2722. Join Two Arrays by ID
// https://leetcode.com/problems/join-two-arrays-by-id/description/?envType=study-plan-v2&envId=30-days-of-javascript

/**
 * @param {Array} arr1
 * @param {Array} arr2
 * @return {Array}
 */
var join = function(arr1, arr2) {
    
    let map = new Map(); 

    for(let elem of arr1){
        map.set(elem.id, {...elem});
    }

    for(let elem of arr2){
        if(map.has(elem.id)){

            let currElem = map.get(elem.id);
            map.set(elem.id, {...currElem, ...elem}); // w overwrite
        }
        else{

            map.set(elem.id, {...elem});
        }
    }

    return Array.from(map.values()).sort((elem1, elem2) => elem1.id - elem2.id);

};

// (24)
// 2705. Compact Object
// https://leetcode.com/problems/compact-object/?envType=study-plan-v2&envId=30-days-of-javascript

/**
 * @param {Object|Array} obj
 * @return {Object|Array}
 */
var compactObject = function compact(obj) {
  
    if(Array.isArray(obj)){

        for(let index = obj.length - 1; index >= 0; index--){

            let elem = obj[index];
            if(typeof elem == "object"){
                
                if(elem === null){
                    obj.splice(index, 1);
                }
                else{
                    compact(elem);
                }
            }
            else{

                if(Boolean(elem) == false){

                    obj.splice(index, 1);
                }
            }
        }
    }
    else{

        for(let key in obj){

            let elem = obj[key];

            if(typeof elem == "object"){

                if(elem === null){
                    delete obj[key];
                }
                else{
                    compact(elem);
                }
            }
            else{

                if(Boolean(elem) == false){
                    delete obj[key];
                }
            }
        }
    }

    return obj;
};

// (25)
// 2695. Array Wrapper
// https://leetcode.com/problems/array-wrapper/?envType=study-plan-v2&envId=30-days-of-javascript
/**
 * @param {number[]} nums
 * @return {void}
 */
var ArrayWrapper = function(nums) {
    
    this.array = nums; 

};

/**
 * @return {number}
 */
ArrayWrapper.prototype.valueOf = function() {
    
    return this.array.length == 0 ? 0 : this.array.reduce((acc, currVal) => acc + currVal); 
}

/**
 * @return {string}
 */
ArrayWrapper.prototype.toString = function() {
    
    let pocketArray = [];

    this.dive(this.array, pocketArray);

    return "[" + pocketArray.toString() + "]";

}

ArrayWrapper.prototype.dive = function(arr, pocket){

    if(arr.length == 0) {return;}

    for(let elem of arr){
        
        Array.isArray(elem) ? this.dive(elem) : pocket.push(elem);
    }
}

/**
 * const obj1 = new ArrayWrapper([1,2]);
 * const obj2 = new ArrayWrapper([3,4]);
 * obj1 + obj2; // 10
 * String(obj1); // "[1,2]"
 * String(obj2); // "[3,4]"
 */

// (26)
// 2726. Calculator with Method Chaining
// https://leetcode.com/problems/calculator-with-method-chaining/?envType=study-plan-v2&envId=30-days-of-javascript


class Calculator {
    
    /** 
     * @param {number} value
     */
    constructor(value) {
        this.result = value;
        return this;
    }
    
    /** 
     * @param {number} value
     * @return {Calculator}
     */
    add(value){
        this.result += value;
        return this;
    }
    
    /** 
     * @param {number} value
     * @return {Calculator}
     */
    subtract(value){
        this.result -= value;
        return this; 
    }
    
    /** 
     * @param {number} value
     * @return {Calculator}
     */  
    multiply(value) {
        this.result *= value;
        return this; 
    }
    
    /** 
     * @param {number} value
     * @return {Calculator}
     */
    divide(value) {

        if(value == 0){
            throw "Division by zero is not allowed"
        }

        this.result /= value;
        return this; 
    }
    
    /** 
     * @param {number} value
     * @return {Calculator}
     */
    power(value){
        this.result = Math.pow(this.result, value);
        return this;
    }
    
    /** 
     * @return {number}
     */
    getResult() {
        return this.result;
    }
}