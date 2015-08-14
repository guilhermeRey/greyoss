var LocalStorageDb = function () {
  this.context = '';
  this.seq = 1;

  this.key = function (keyname) {
    return [this.context, keyname || this.seq++].join('.');
  };
};

LocalStorageDb.prototype.save = function (keyName, obj) {
  localStorage.setItem(this.key(keyName), obj);
  return this;
};

LocalStorageDb.prototype.dbcontext = function (contextName) {
  this.context = contextName;
  return this;
};

LocalStorageDb.prototype.where = function (keyName) {
  return localStorage.getItem(this.key(keyName));
}

 var DnD = {
   game: {
     name: 'Campanha de Garth',
     players: [
      {
        name: 'Sir Eriah',
        ac: 16,
        initiative: 4,
        hp: 11,
        age: '33',
        sex: 'Male',
        height: '1.85',
        weight: '90',
        favoriteWeapon: 'long sword',
        alignment: 'lawful good',
        history: "Sir Eriah, vem de uma familia humilde. Seu pai, Ludwing, um ex-soldado real e hoje ferreiro aposentado, sempre fez questão de \
              educar seu filho (de maneira rigida demais) para que seguisse um caminho diferente do seu e tivesse sucesso na vida(dinheiro). \
              Desde pequeno Eriah passava os dias estudando religião e cultura na fazenda onde moravam. Sua mãe, Amélia, uma agricultora da local, \
              vendia hortaliças para sustentar a familia nos longos periodos que Ludwing passava fora em guerras ou missões. \
              Quando tinha 8 anos, Eriah passou pela experiencia que iria transformar sua vida. \
              Em uma noite escura, Eriah acorda assustado ouvindo gritos em sua janela, quando ele olha, ve seu pai lutando bravamente \
              contra um bando de orcs saqueadores. \
              Eriah, que não havia sido treinado em combate junta suas forças em meio as lagrimas e ora ao seu Deus Heironeous, Deus do heroismo, \
              para que salve sua familia, e então como magica um grande barulho é ouvido e um clarão ilumina as plantações, como um trovão caindo \
              do céu, Eriah ve a mão de Heironeous caindo sobre os bandidos e espalhando fogo em algumas plantas. \
              Isso foi suficiente para espantar os orcs incredulos e salvar sua familia. Mas não sem causar estragos. Seu pai acaba por sofrer um \
              corte durante a luta e perde a perna (motivo de se tornar um ferreiro).  \
              Eriah acredita que Heironeuous o salvou pois tinha uma missão a ser cumprida e deveria se tornar um soldado do Deus. \
              Então se engaja em treinar com seu pai e posteriormente com cavaleiros templarios, onde foi obrigado a abandonar seus pais para \
              se especializar no treinamento, que era divido em combate e fé. Após os 19 anos, com o sucesso de sua primeira missão de fé, \
              recebe o titulo de Sir. \
              Hoje Sir Eriah tem como objetivo espalhar a palavra e a força de Heironeus para os indefesos e destruir toda e qualquer fonte do mal."
      },
      {
        name: 'Beren',
        ac: 15,
        initiative: 7,
        hp: 7,
        age: '35',
        sex: 'Male',
        height: '1.80',
        weight: '75',
        favoriteWeapon: 'bow and arrow',
        race: 'hald-elf',
        claz: 'bugler',
        alignment: 'chaotic neutral',
        history: 'Berem é filho de uma elfa com um humano ladino, que foi contratado para matar sua mãe, mas eles acabaram se apaixonando e ficaram juntos. \
              Seu avô descobriu a intenção inicial de seu pai e acabou assassinando-o. Sua mãe faleceu ao dar a luz a Beren, logo Beren foi criado pelo avô. \
              Com 10 anos Beren mata seu avô, por ele ser um escravocrata e tratá-lo como bastardo. Um andarilho encontrou Beren, e reconhecendo o colar de seu Pai acabou por levá-lo para a Guilda de assassinos.'
      },
      {
        name: 'Meitán Pifu',
        ac: 15,
        initiative: 2,
        hp: 9,
        age: '28',
        sex: 'Male',
        height: '1.70',
        weight: '60',
        favoriteWeapon: 'besta',
        race: 'humano',
        claz: 'monge',
        alignment: 'lawful neutral',
        history: ''
      },
      {
        name: 'Argoth Greymane',
        ac: 18,
        initiative: 2,
        hp: 11,
        age: '150',
        sex: 'Male',
        height: '1.64',
        weight: '120',
        favoriteWeapon: 'double handed axe',
        race: 'anão',
        claz: 'guerreiro',
        alignment: 'chaotic neutral',
        history: ''
      }
    ],
     world: {
       name: 'Garth',
       map: 'maps/worldmap.png'
     },
     adventures: [{
         id: 1,
         name: 'IV CAF',
         description: 'Os heróis precisam viajar até o país de ESTROV, onde ocorre o IV CAF e conseguir informações sobre uma possível conspiração para guerra.',
         scenes: [{
               name: 'O encontro na taverna',
               description: 'O grupo se encontra na taverna',
               location: {
                 name: 'Taverna',
                 map: 'dnd_resources/maps/tavern.jpg'
               },
               npcs: [],
               monsters: [],
               musics: []
         }, {
               name: 'Reunião no QG',
               description: 'O grupo de heróis se encontra com o guarda real para negociar sobre o suposto trabalho',
               location: {
                 name: 'QG da Guarda Real',
                 map: 'maps/tabern.png'
               },
               npcs: [],
               monsters: [],
               musics: []
         }, {
               name: 'Viagem para Estrov',
               description: 'O grupo de heróis se encontra com o guarda real para negociar sobre o suposto trabalho',
               location: {
                 name: 'QG da Guarda Real',
                 map: 'dnd_resources/maps/forest.jpg'
               },
               npcs: [],
               monsters: [],
               musics: []
         }, {
               name: 'Chegando em Estrov',
               description: 'A cidade de Theogonia, a capital de Estrov, é uma cidade de humanos que possui grande número populacional',
               location: {
                 name: 'Estrov',
                 map: 'dnd_resources/maps/estrov.jpg'
               },
               npcs: [],
               monsters: [],
               musics: []
         }, {
               name: 'IV CAF',
               description: '',
               location: {
                 name: 'Estrov',
                 map: 'dnd_resources/maps/castle.jpg'
               },
               npcs: [],
               monsters: [],
               musics: []
         }, {
               name: 'IV CAF - Group Rounds - Dungeons',
               description: '',
               location: {
                 name: 'CAF Dungeon',
                 map: 'dnd_resources/maps/first_dungeon.png'
               },
               npcs: [],
               monsters: [{
                 name: 'Beholder',
                 image: 'dnd_resources/monsters/beholder.jpg',
                 ac: 12,
                 hp: 11,
                 initiative: 0,
                 weapon: null,
                 spells: [{
                   name: 'Eye Ray',
                   damage: '2d4 + 2'
                 }],
                 instances: [1, 2, 3]
               }],
               musics: [{
                 name: 'Dungeon',
                 file: 'dnd_resources/musics/65_Dungeon_I.mp3'
               }]
         }, {
               name: 'IV CAF - Group Rounds - Dungeons - Segundo Nível',
               description: 'Uma caverna sombria e gélida, com rochas firmes e úmidas',
               location: {
                 name: 'CAF Dungeon - Level 2',
                 map: 'dnd_resources/maps/dungeon2.jpg'
               },
               npcs: [],
               monsters: [{
                 name: 'Beholder',
                 image: 'dnd_resources/monsters/beholder.jpg',
                 ac: 12,
                 hp: 11,
                 initiative: 0,
                 weapon: null,
                 spells: [{
                   name: 'Eye Ray',
                   damage: '2d4 + 2'
                 }]
               }, {
                 name: 'Skeleton Warrior',
                 image: 'dnd_resources/monsters/skeleton_warrior.jpg',
                 ac: 14,
                 hp: 18,
                 initiative: 0,
                 weapon: null,
                 spells: [{
                   name: 'Club Punch',
                   damage: '1d4 + 2'
                 }]
               }, {
                 name: 'Skeleton Archer',
                 image: 'dnd_resources/monsters/skeleton_archer.jpg',
                 ac: 11,
                 hp: 15,
                 initiative: 3,
                 weapon: null,
                 spells: [{
                   name: 'Fire Arrow',
                   damage: '1d6 + 1'
                 }]
               }, {
                 name: 'Necromancer',
                 image: 'dnd_resources/monsters/necromancer.jpg',
                 ac: 13,
                 hp: 45,
                 initiative: 3,
                 weapon: null,
                 spells: [{
                   name: 'Shadow Ball',
                   damage: '1d6'
                 }, {
                   name: 'Reviver Esqueleto',
                   damage: '1d8'
                 }]
               }, {
                 name: 'Elfo Amigo',
                 image: 'dnd_resources/monsters/necromancer.jpg',
                 ac: 15,
                 hp: 7,
                 initiative: 3,
                 weapon: null,
                 spells: [{
                   name: 'Arco e Flecha',
                   damage: '1d8'
                 }]
               }, {
                 name: 'Elfa Amiga',
                 image: 'dnd_resources/monsters/necromancer.jpg',
                 ac: 15,
                 hp: 9,
                 initiative: 3,
                 weapon: null,
                 spells: [{
                   name: 'Adaga Dupla',
                   damage: '2d4'
                 }]
               }],
               musics: [{
                 name: 'Dungeon',
                 file: 'dnd_resources/musics/65_Dungeon_I.mp3'
               }]
         }]
       }]
   },

   loadCampaign: function (campaignId) {
     return new DungeonsAndDragons(DnD.game);
   },

   DB: {
     _instance: null,
     instance: function () {
        if (DnD.DB._instance === null) {
          DnD.DB._instance = new LocalStorageDb();
        }

        return DnD.DB._instance;
     }
   }
 };

/**
 * MainCtrl - controller
 */
function MainCtrl($scope) {

    this.dungeonMaster = {
      name: 'Guilherme Rey',
      email: 'poli.rey@gmail.com'
    };

    this.game = new DungeonsAndDragons(DnD.game);
    $scope.config = {
      full: false
    };

    this.toggleConfigView = function () {
      $scope.config.full = !$scope.config.full;
    };
};

function AdventureCtrl($scope, $stateParams, $interval) {
  var db = DnD.DB.instance().dbcontext('DnD');

  $scope.id = $stateParams.id;
  $scope.game = DnD.loadCampaign();

  $scope.current = {
    adventure: $scope.game.AdventureById($scope.id)
  };

  db.save('game', JSON.stringify($scope.game));
  db.save('current.adventure', JSON.stringify($scope.current.adventure));

  $scope.selectScene = function (scene) {
    $scope.current.scene = scene;

    db.save('game', JSON.stringify($scope.game));
    db.save("current.scene", JSON.stringify($scope.currentScene));
  };
}

function SceneController($scope, $stateParams, $interval, $timeout) {
  var db = DnD.DB.instance().dbcontext('DnD'),
      sceneidx = parseInt($stateParams.id);

  $scope.init = function () {
    $scope.adventure = JSON.parse(db.where('current.adventure'));
    $scope.scene = $scope.adventure.scenes[sceneidx];
    $scope.rolls = [];
    $scope.isRolling = false;

    $scope.scene.current = {
      music: $scope.scene.musics[0],
      monster: '',
      grid: {
        top:  '',
        left: '',
        zoom: '600%'
      },
      dungeon: {
        monsters: []
      }
    };

    $scope.previous = sceneidx > 0 ? $scope.adventure.scenes[sceneidx - 1] : {
      name: ''
    };
    $scope.next = sceneidx < $scope.adventure.scenes.length - 1 ? $scope.adventure.scenes[sceneidx + 1] : {
      name: ''
    };
    $scope.previous.id = sceneidx - 1;
    $scope.next.id = sceneidx + 1;

    $interval(function() {
       db.save('current-grid', $('<div>').append($('#dungeon-grid').clone()).html());
       db.save('current-monster', $scope.scene.current.monster);
    }, 500);
  }

  $scope.refreshMonsters = function () {
    $scope.scene.current.dungeon.monsters = [];
  };

  $scope.hitMonster = function (monster) {
    monster.hp--;
  };

  $scope.addMonster = function (monster) {
    var newMonster = {
      name: monster.name + ' ' + (parseInt($scope.scene.current.dungeon.monsters.length) + 1),
      hp: monster.hp
    };
    $scope.scene.current.dungeon.monsters.push(newMonster);
    $timeout(function () {
      $( ".draggable" ).draggable({
        containment: 'parent'
      });
    }, 1000);
  }

  $scope.dropped = function(dragEl, dropEl) { // function referenced by the drop target
    //this is application logic, for the demo we just want to color the grid squares
		//the directive provides a native dom object, wrap with jqlite
		var drag = $('#' + dragEl);
    var drop = $('#' + dropEl);

    drop.css('background-color', drag.attr('data-color'));
    drop.text(drag.attr('data-drop-name'));
    drop.attr('data-color', drag.attr('data-color'));
    drop.attr('x-lvl-draggable', 'true');

		// if element has been dragged from the grid, clear dragged color
		if (drag.attr("x-lvl-drop-target")) {
			drag.css('background-color', 'rgba(255, 255, 255, 0.3)');
		}
	}

  $scope.music = function (m) {
    $scope.scene.current.music = m;
  };

  $scope.initiativeRoll = function (modifier) {
    $scope.rollDice('Iniciativa (1d20 + ' + modifier + ')', Dice.damage('1d20')());
  };

  $scope.damageRoll = function (spell) {
    $scope.rollDice(spell.name + ' (' + spell.damage + ')', Dice.damage(spell.damage)());
  };

  $scope.rollDice = function (d, r) {
    $scope.isRolling = true;
    $('#dice-roll-sound').on('click', function () { this.play(); });
    $('#dice-roll-sound').trigger('click');

    $timeout(function () {
      $scope.rolls.push({
        text: d,
        result: r
      });
      $scope.isRolling = false;
    }, 1200);
  };
}

function SceneCtrl($scope, $stateParams, $interval) {
  var db = DnD.DB.instance().dbcontext('DnD');
  $interval(function () {
    $('#canvas').html(db.where('current-grid'));
    $scope.monster = db.where('current-monster');
  }, 500);

  /*$scope.game = JSON.parse(localStorage.getItem("DnD.game"));
  $scope.adventure = $scope.game.AdventureById($scope.id);
  $scope.currentScene = $scope.adventure.scenes[0];

  console.log($scope.game);
  $scope.scene = {
    location: {}
  };
  $scope.scene.name = localStorage.getItem('DnD.current.scene.name');
  $scope.scene.location.map = localStorage.getItem('DnD.current.scene.location.map');
  $scope.scene.chars = [{},{},{},{}];

  for (var i = 0; i < 4; i++) {
    $scope.scene.chars[i].name = localStorage.getItem('DnD.current.scene.char' + i + '.name');
  }

  $interval(function() {
    $scope.scene.name = (localStorage.getItem('DnD.current.scene.name'));
    $scope.scene.location.map = localStorage.getItem('DnD.current.scene.location.map');

    for (var i = 0; i < 4; i++) {
      $scope.scene.chars[i].top = localStorage.getItem('DnD.current.scene.char' + i + '.top');
      $scope.scene.chars[i].left = localStorage.getItem('DnD.current.scene.char' + i + '.left');
    }
  }, 500);*/
}


angular
    .module('inspinia')
    .controller('MainCtrl', MainCtrl)
