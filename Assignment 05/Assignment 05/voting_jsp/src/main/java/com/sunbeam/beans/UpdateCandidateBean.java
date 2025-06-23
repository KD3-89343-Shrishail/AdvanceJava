
package com.sunbeam.beans;

import com.sunbeam.daos.CandidateDao;

import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.pojos.Candidate;

public class UpdateCandidateBean {
	private int id;
	private String name;
	private String party;
	private int votes;
	private int count;
  
	private boolean savestatus;

	public UpdateCandidateBean() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParty() {
		return party;
	}

	public void setParty(String party) {
		this.party = party;
	}

	public int getVotes() {
		return votes;
	}

	public void setVotes(int votes) {
		this.votes = votes;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	public void setSavestatus(boolean savestatus) {
		this.savestatus = savestatus;
	}

	public boolean getSavestatus() {
		return savestatus;
	}

	
	public void updateCandidate() {
		try(CandidateDao candDao = new CandidateDaoImpl()) {
			Candidate c = new Candidate(id, name, party, votes);
			this.count = candDao.update(c);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public void addCandidate() {
		try(CandidateDao candDao = new CandidateDaoImpl()) {
			Candidate c = new Candidate(0, name, party, votes);
			this.count = candDao.save(c);
			this.savestatus= count == 1 ;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
}