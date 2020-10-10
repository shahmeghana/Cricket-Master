package com.nouhoun.springboot.jwt.integration.service.impl;

import com.nouhoun.springboot.jwt.integration.domain.Match;
import com.nouhoun.springboot.jwt.integration.domain.TeamList;
import com.nouhoun.springboot.jwt.integration.domain.TimeTable;
import com.nouhoun.springboot.jwt.integration.domain.Tournament;
import com.nouhoun.springboot.jwt.integration.repository.TeamListRepository;
import com.nouhoun.springboot.jwt.integration.repository.TimeTableRepository;
import com.nouhoun.springboot.jwt.integration.repository.TournamentReposiory;
import com.nouhoun.springboot.jwt.integration.service.MatchService;
import com.nouhoun.springboot.jwt.integration.util.MatchAdapter;
import com.nouhoun.springboot.jwt.integration.util.Output;
import com.nouhoun.springboot.jwt.integration.util.Output.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by mshah on 03/08/20.
 */
@Service
public class MatchServiceImpl implements MatchService {
    @Autowired
    private TimeTableRepository timeTableRepository;
    @Autowired
    private TeamListRepository teamListRepository;
	@Autowired
	private TournamentReposiory tournamentReposiory;
	@Value("${cricket.punter.default.tournamentName}")
	private String tournamentName;
	@Value("${cricket.punter.default.tournamentDescription}")
	private String tournamentDescription;

    @Value("${cricket.punter.default.tournamentId}")
    private Long tournamentId;

    List<TeamList> allTeamDetails;
    Tournament tournament;

    // This method will be executed by Spring as soon as MatchService Bean is created
    // That means allTeamDetails and tournament objects get initialized even before any request is received
    // So we can easily share them across the class
    // This reduces the need to fetch same data again and again from database

    @PostConstruct
    void fillCache() {
        allTeamDetails = teamListRepository.findAll();
        tournament = getTournament(tournamentId);
    }

    Tournament getTournament(Long tournamentId) {
        Optional<Tournament> tnmt = tournamentReposiory.findById(tournamentId);

        return tnmt.orElseGet(() -> {
            Tournament tournament2 = new Tournament();
            tournament2.setTournamentName(tournamentName);
            tournament2.setDescription(tournamentDescription);
            return tournament2;
        });
    }

    @Override
    public Output getTimeTable(){
    	final List<Match> matches = new ArrayList<Match>();
		Output out =  new Output();

        // Don't want to fetch teamDetails and tournament details again and again
        // This change reduced api response time from 42s to 3s
        // Since neither of this data is going to change throughout the tournament,
        // we can use @PostConstruct annotation and cache all this data as soon as application boots up

        List<TimeTable> timeTables = timeTableRepository.findAll();
    	for(TimeTable timeTable : timeTables)
    	{
            Optional<TeamList> team1 = allTeamDetails.stream()
                .filter(teamDetails -> teamDetails.getId() == timeTable.getTeam1Id())
                .findFirst();

            Optional<TeamList> team2 = allTeamDetails.stream()
                .filter(teamDetails -> teamDetails.getId() == timeTable.getTeam2Id())
                .findFirst();

            if (!team1.isPresent() || !team2.isPresent()) {
                continue;
            }

            final MatchAdapter convertor = new MatchAdapter(timeTable);
            final Match match = convertor.convertToMatch(team1.get(), team2.get(), tournament);
            match.setComment(timeTable.getComment());
    		matches.add(match);
    	}

    	out.setResponseCode(ResponseCode.SUCCESS.getCode());
    	out.setMessage("All matches Fetched...");
    	out.setResults("matches", matches);;
    	return out;
    }


    @Override
	public Match getMatch(TimeTable timeTable) {
        Optional<TeamList> team1 = allTeamDetails.stream()
            .filter(teamDetails -> teamDetails.getId() == timeTable.getTeam1Id())
            .findFirst();

        Optional<TeamList> team2 = allTeamDetails.stream()
            .filter(teamDetails -> teamDetails.getId() == timeTable.getTeam2Id())
            .findFirst();

		final MatchAdapter convertor = new MatchAdapter(timeTable);
        final Match match = convertor.convertToMatch(team1.get(), team2.get(), tournament);
		match.setComment(timeTable.getComment());
		return match;
	}
}
