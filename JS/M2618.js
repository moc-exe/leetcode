// MEDIUM 2618. Check if Object Instance of Class
// https://leetcode.com/problems/check-if-object-instance-of-class/description/

/**
 * @param {*} obj
 * @param {*} classFunction
 * @return {boolean}
 */
var checkIfInstanceOf = function(obj, classFunction) {
    
    if(obj == null){return false;}
    if(classFunction == null){return false;}

    let currPrototype = Object.getPrototypeOf(obj);
    while (currPrototype !== null) {
    if (currPrototype === classFunction.prototype) {
        return true;
    }
    currPrototype = Object.getPrototypeOf(currPrototype);
}
return false;

};
/**
 * checkIfInstanceOf(new Date(), Date); // true
 */