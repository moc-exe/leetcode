/**
 * @return {Generator<number>}
 */
var fibGenerator = function*() {
    
    let prev = 0; 
    let curr = 1; 
    
    yield 0;
    yield 1;

    while(true){

        let temp = curr; 
        curr = prev + curr;
        prev = temp;
        yield curr;
    
    }

};

/**
 * const gen = fibGenerator();
 * gen.next().value; // 0
 * gen.next().value; // 1
 */