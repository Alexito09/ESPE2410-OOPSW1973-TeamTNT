export default class soccerBall {
    constructor(id, brand, size, material){
        this._id = id;
        this._brand = brand;
        this._size = size;
        this._material = material;
    }

toString(){
    return `soccerBall{id='${this._id}', brand='${this._brand}', size='${this.size}}', material=${this._material}}`;
}

get id() {
    return this._id;
}

set id(value) {
    this._id = value;
}

get brand() {
    return this._brand;
}

set brand(value) {
    this._brand = value;
}

get size() {
    return this.size;
}

set size(value) {
    this.size = value;
}

get material() {
    return this.material;
}

set material(value) {
    this.material = value;
}
}