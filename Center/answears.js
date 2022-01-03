const fs = require('fs');

function answear(code) {
	try {
		const answears = JSON.parse(fs.readFileSync('./answears.json', 'utf8'));
		if (answears[code] instanceof Array) {
			max = answears[code].length;
			random_indx = Math.floor(Math.random()*(max));
			return answears[code][random_indx];
		} else {
			return answears[code];
		}
	} catch (err) {
		return `Reading file Error: ${err}`;
	}
}

exports.answear = answear;