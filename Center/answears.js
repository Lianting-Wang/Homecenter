const answears = require('./answears.json')

function answear(code) {
	if (answears[code] instanceof Array) {
		max = answears[code].length;
		random_indx = Math.floor(Math.random()*(max));
		return answears[code][random_indx];
	} else {
		return answears[code];
	}
}

exports.answear = answear;