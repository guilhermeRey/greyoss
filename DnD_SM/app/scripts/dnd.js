var DnDHelper = {
  getMap: function (fileName) {
    return 'app/dnd_resources/maps/' + fileName;
  }
};

var Dice = {
  roll: function(qt, faces) {
    var rolls = [];
    for (var i = 0; i < qt; i++) {
      rolls.push(Math.floor((Math.random() * faces) + 1));
    }
    return rolls.reduce(function (a, b) {
      return a + b;
    });
  },
  damage: function (dmg) {
    var dices = [];
    for (var i = 0; i < dmg.length; i++) {
      if (dmg[i].toUpperCase() == 'D') {
        dmg[i] = 'd';
        var diceQty = '',
            diceType = '',
            j = i,
            k = i;

        while (dmg[--j] !== undefined && !isNaN(dmg[j])) {
          diceQty += dmg[j];
        }

        while(dmg[++k] !== undefined && !isNaN(dmg[k])) {
          diceType += dmg[k];
        }

        diceQty = parseInt(diceQty);
        diceType = parseInt(diceType);

        dices.push({
          name: 'd' + diceType,
          faces: diceType,
          quantity: diceQty,
          exp: diceQty + 'd' + diceType,
          evalExp: 'Dice.roll(' + diceQty + ', ' + diceType + ')'
        });

        i = k;
        continue;
      }
    }

    for (var l = 0; l < dices.length; l++) {
      dmg = dmg.replace(dices[l].exp, dices[l].evalExp);
    }

    return function () {
      return eval(dmg);
    };
  }
}


var DungeonsAndDragons = function DungeonsAndDragons(args) {
  var me = this;

  this.name = args.name;
  me.players = [];
  me.adventures = [];
  me.world = args.world;

  _.each(args.players, function (e) {
    me.players.push(new Player(e));
  });

  _.each(args.adventures, function (a) {
    me.adventures.push(new Adventure(a));
  });

  this.AdventureById = function (idToFind) {
    var search = {
      id: parseInt(idToFind)
    };
    return _.findWhere(me.adventures, search);
  }
};

var Player = function Player(args) {
  this.name = args.name;
  this.age = args.age;
  this.sex = args.sex;
  this.height = args.height;
  this.weigth = args.weigth;
  this.favoriteWeapon = args.favoriteWeapon;
  this.alignment = args.alignment;
  this.history = args.history;
  this.ability = {
    dex: args.dex || 0,
    con: args.con || 0,
    int: args.int || 0,
    wis: args.wis || 0,
    cha: args.cha || 0
  };
  this.ac = args.ac;
  this.initiative = args.initiative;
  this.hp = args.hp;
  this.currentHp = args.currentHp || this.hp;

  this.restore = function (torestore) {
    if (torestore + this.currentHp > this.hp) {
      this.currentHp = this.hp;
    }
    else {
      this.currentHp += torestore;
    }
  };

  this.hit = function (damage) {
    this.currentHp -= damage;
  };

  this.php = function () {
    return parseFloat((this.currentHp * 100.0) / this.hp).toFixed(2);
  };

  this.currentColorHp = function () {
    var hpPercentage = this.php();

    if (hpPercentage <= 25)
      return "red-bg";
    else if (hpPercentage <= 65)
      return 'yellow-bg';

    return 'navy-bg';
  };
};

var Adventure = function Adventure(args) {
  this.id = args.id;
  this.name = args.name;
  this.description = args.description;
  this.scenes = [];

  if (args.scenes && args.scenes.length > 0) {
    for (var i = 0; i < args.scenes.length; i++)
      this.scenes.push(new Scene(args.scenes[i]));
  }
};

/*
  Represents a game's adventure Scene
*/
var Scene = function Scene(args) {

  this.name = args.name;
  this.description = args.description;
  this.location = new Location(args.location);
  this.dungeon = new Dungeon(args.dungeon || {maps:[]});
  this.npcs = args.npcs;
  this.monsters = args.monsters;
  this.musics = args.musics;
  this.positions = [];
};

var Location = function Location(options) {
  this.name = options.name;
  this.map = options.map;
};

var Dungeon = function Dungeon(options) {
  this.maps = options.maps || [];
};
