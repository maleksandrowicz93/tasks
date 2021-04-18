var Wrap = (function () {
	function User(name) {
		this.name = name;
	}

	var d = function () {
		return "Thank you for logging in " + this.name;
	};

	User.prototype.thankForLoggingIn = d;

	return User;
})();

var bob = new Wrap("Bob");
console.log(bob.thankForLoggingIn());