/*
	This file is part of jLCM
	
	Copyright 2013 Martin Kirchgessner, Vincent Leroy, Alexandre Termier, Sihem Amer-Yahia, Marie-Christine Rousset, Université Joseph Fourier and CNRS

	Licensed under the Apache License, Version 2.0 (the "License");
	you may not use this file except in compliance with the License.
	You may obtain a copy of the License at

	 http://www.apache.org/licenses/LICENSE-2.0
	 
	or see the LICENSE.txt file joined with this program.

	Unless required by applicable law or agreed to in writing, software
	distributed under the License is distributed on an "AS IS" BASIS,
	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	See the License for the specific language governing permissions and
	limitations under the License.
*/


package fr.liglab.mining.tests;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import fr.liglab.mining.internals.Counters;
import fr.liglab.mining.internals.ExplorationStep;
import fr.liglab.mining.internals.Dataset.TransactionsIterable;

public class CompactionTest {

	@Test
	public void test() {
		
		ExplorationStep init = new ExplorationStep(2, FileReaderTest.PATH_MICRO);
		
		TransactionsIterable support = init.dataset.getSupport(1);
		Counters candidateCounts = new Counters(2, support.iterator(), 
				1, null, 5);
		System.out.println(Arrays.toString(init.counters.getReverseRenaming()));
		int[] renaming = candidateCounts.compressRenaming(init.counters.getReverseRenaming());
		
		System.out.println(Arrays.toString(renaming));
		
	}

}
