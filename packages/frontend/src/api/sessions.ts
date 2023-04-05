export function getBreaks() {
  return [
    {
      name: 'Mittagessen',
      start: 6,
      duration: 2
    },
    {
      name: 'Pause',
      start: 10,
      duration: 1
    }
  ];
}

export function getRooms() {
  const rooms = [
    {
      name: 'Labor',
      color: '#248746',
      sessions: [
        {
          name: 'Arduino Hacken mit LED Strips',
          host: 'Lukas Bauer',
          start: 0,
          duration: 3
        },
        {
          name: 'Custom Keyboards selbst löten',
          host: 'Justin Biber',
          start: 4,
          duration: 2
        },
        {
          name: 'Debatieren über den Sinn des Lebens denn das Leben hat überhaupt keinen Sinn und ist einfach nur Toll',
          host: 'Elon Musk',
          start: 11,
          duration: 10
        }
      ]
    },
    {
      name: 'Große Halle',
      color: '#2a7196',
      sessions: [
        {
          name: 'Vue.js 3 für Profis',
          host: 'Mare Walzl',
          start: 1,
          duration: 3
        },
        {
          name: 'React.js ist schlechter als Vue',
          host: 'Mark Zuckerberg',
          start: 4,
          duration: 2
        }
      ]
    },
    {
      name: 'Abstellkammer',
      color: '#b32765',
      sessions: [
        {
          name: 'Pinsel putzen',
          host: 'Peter Pan',
          start: 5,
          duration: 3
        },
        {
          name: 'Eimer auffüllen',
          host: 'Reiner Zufall',
          start: 10,
          duration: 8
        }
      ]
    },
    {
      name: 'Hundehütte',
      color: '#ea580c',
      sessions: [
        {
          name: 'Kickern für Anfänger',
          host: 'Michael Ballack',
          start: 0,
          duration: 4
        },
        {
          name: 'Tore halten für Profis',
          host: 'Ulli Höhnes',
          start: 6,
          duration: 3
        },
        {
          name: 'Richtig Passen',
          host: 'Sebastian Schweinsteiger',
          start: 11,
          duration: 12
        }
      ]
    },
    {
      name: 'Lager',
      color: '#65a30d',
      sessions: [
        {
          name: 'Gabelstapler fahren',
          host: 'Baggerfahrer Franz',
          start: 7,
          duration: 7
        },
        {
          name: 'Kisten Workout',
          host: 'Arnold Schwarzenegger',
          start: 15,
          duration: 6
        }
      ]
    },
    {
      name: 'Arbeitszimmer',
      color: '#581c87',
      sessions: [
        {
          name: 'Schreibtisch aufbauen',
          host: 'Bob der Baumeister',
          start: 1,
          duration: 3
        },
        {
          name: 'Bienen züchten leicht gemacht',
          host: 'Biene Maja',
          start: 5,
          duration: 8
        }
      ]
    },
    {
      name: 'Büro',
      color: '#0284c7',
      sessions: [
        {
          name: 'Schlafen',
          host: 'Julien Bam',
          start: 0,
          duration: 20
        }
      ]
    },
    {
      name: 'Schloss',
      color: '#f472b6',
      sessions: [
        {
          name: 'Kinderschminken',
          host: 'Prinzessin',
          start: 1,
          duration: 4
        },
        {
          name: 'Hüpfburg',
          host: 'Flummy Flummy',
          start: 9,
          duration: 10
        }
      ]
    }
  ]

  return rooms
}
