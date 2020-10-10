let fetch = require('node-fetch')
const fs = require('fs');

let link = 'https://cricketapi.platform.iplt20.com//fixtures?tournamentIds=18790&pageSize=100'
let matches = []
const filename = 'download.csv'

const teamId = {
    'MI': 1,
    'CSK': 2,
    'DC': 3,
    'KXIP': 4,
    'RCB': 5,
    'KKR': 6,
    'SRH': 7,
    'RR': 8
}

fetch(link)
    .then(res => res.json())
    .then(res => {
        res.content.map(fix => {
            let {timestamp, label, scheduleEntry} = fix
            let match = {}
            match.evenDate = getDate(timestamp)
            match.ipllabel = label
            match.iplId = scheduleEntry.matchId.id
            match.iplname = scheduleEntry.matchId.name
            match.stadium = scheduleEntry.venue.city
            match.comment = scheduleEntry.matchStatus ? scheduleEntry.matchStatus.text : 'NULL' 
            match.name = `${scheduleEntry.team1.team.abbreviation} vs ${scheduleEntry.team2.team.abbreviation}`
            match.season = '2020'
            match.tournamentId =  1

            match.team1 = teamId[scheduleEntry.team1.team.abbreviation]
            match.team2 = teamId[scheduleEntry.team2.team.abbreviation]


            match.winnerid = scheduleEntry.matchStatus 
                ? scheduleEntry.matchStatus.outcome === 'B' 
                    ? teamId[scheduleEntry.team2.team.abbreviation] 
                    : teamId[scheduleEntry.team1.team.abbreviation]
                : 'NULL'

            matches.push(match)
        })
    })
    .then(() => console.log(matches))
    .then(() => {
        const replacer = (key, value) => value === null ? '' : value // specify how you want to handle null values here
        const header = Object.keys(matches[0])
        let csv = matches.map(row => header.map(fieldName => JSON.stringify(row[fieldName], replacer)).join(','))
        csv.unshift(header.join(','))
        csv = csv.join('\r\n')
        fs.writeFileSync(filename, csv)
    })
    .catch(e => console.error(e))


    function getDate(timestamp) {
        let date = new Date(timestamp)
        return `${date.getFullYear()}-${date.getMonth()+1}-${date.getDate()} ${date.getHours()}:${date.getMinutes()}:00`
    }