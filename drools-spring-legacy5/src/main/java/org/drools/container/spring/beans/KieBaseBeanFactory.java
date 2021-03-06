/*
 * Copyright 2010 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.drools.container.spring.beans;

import org.drools.core.base.evaluators.EvaluatorDefinition;
import org.drools.grid.GridNode;
import org.kie.api.KieBase;
import org.kie.internal.KnowledgeBase;
import org.kie.api.runtime.rule.AccumulateFunction;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class KieBaseBeanFactory
    implements
    FactoryBean,
    InitializingBean {

    private Map<String, AccumulateFunction>  accumulateFunctions;
    private Map<String, EvaluatorDefinition> evaluators;

    private KieBase                    kbase;
    private GridNode                         node;
    private List<DroolsResourceAdapter>      resources = Collections.emptyList();

    public Object getObject() throws Exception {
        return kbase;
    }

    public Class< ? extends KnowledgeBase> getObjectType() {
        return KnowledgeBase.class;
    }

    public boolean isSingleton() {
        return true;
    }

    public void afterPropertiesSet() throws Exception {
//        if ( this.node == null ) {
//            this.node = new GridNodeImpl();
//            //            GenericConnection connection = new GridConnection();
//            //            connection.addExecutionNode(new LocalNodeConnector());
//            //            connection.addDirectoryNode(new LocalDirectoryConnector());
//            //            this.node = connection.getExecutionNode();
//
//        }
//
//        PackageBuilderConfiguration kconf = (PackageBuilderConfiguration) KnowledgeBuilderFactory.newKnowledgeBuilderConfiguration();
//        if ( this.accumulateFunctions != null && !this.accumulateFunctions.isEmpty() ) {
//            for ( Entry<String, AccumulateFunction> entry : this.accumulateFunctions.entrySet() ) {
//                kconf.setOption( AccumulateFunctionOption.get( entry.getKey(),
//                                                               entry.getValue() ) );
//            }
//        }
//
//        if ( this.evaluators != null && !this.evaluators.isEmpty() ) {
//            for ( Entry<String, EvaluatorDefinition> entry : this.evaluators.entrySet() ) {
//                kconf.setOption( EvaluatorOption.get( entry.getKey(),
//                                                      entry.getValue() ) );
//            }
//        }
//
//        KnowledgeBuilder kbuilder = node.get( KnowledgeBuilderFactoryService.class ).newKnowledgeBuilder( kconf );
//        if ( this.conf != null ) {
//            kbase = node.get( KnowledgeBaseFactoryService.class ).newKnowledgeBase( conf );
//        } else {
//            kbase = node.get( KnowledgeBaseFactoryService.class ).newKnowledgeBase();
//        }
//
//        List<JaxbConfigurationImpl> xsds = new ArrayList<JaxbConfigurationImpl>();
//
//        for ( DroolsResourceAdapter res : resources ) {
//            if ( res.getResourceType().equals( ResourceType.XSD ) ) {
//                xsds.add( (JaxbConfigurationImpl) res.getResourceConfiguration() );
//            }
//
//            if ( res.getResourceConfiguration() == null ) {
//                kbuilder.add( res.getDroolsResource(),
//                              res.getResourceType() );
//            } else {
//                kbuilder.add( res.getDroolsResource(),
//                              res.getResourceType(),
//                              res.getResourceConfiguration() );
//            }
//        }
//
//        KnowledgeBuilderErrors errors = kbuilder.getErrors();
//        if ( !errors.isEmpty() ) {
//            throw new RuntimeException( errors.toString() );
//        }
//
//        kbase.addKnowledgePackages( kbuilder.getKnowledgePackages() );
//
//        KnowledgeBaseImpl kbaseImpl = (KnowledgeBaseImpl) kbase;
//        kbaseImpl.jaxbClasses = new ArrayList<List<String>>();
//        for ( JaxbConfigurationImpl conf : xsds ) {
//            kbaseImpl.jaxbClasses.add( conf.getClasses() );
//        }

    }

    public Map<String, AccumulateFunction> getAccumulateFunctions() {
        return accumulateFunctions;
    }

    public void setAccumulateFunctions(Map<String, AccumulateFunction> accumulateFunctions) {
        this.accumulateFunctions = accumulateFunctions;
    }

    public Map<String, EvaluatorDefinition> getEvaluators() {
        return evaluators;
    }

    public void setEvaluators(Map<String, EvaluatorDefinition> evaluators) {
        this.evaluators = evaluators;
    }

//    public KieBaseConfiguration getConf() {
//        return conf;
//    }
//
//    public void setConf(KieBaseConfiguration conf) {
//        this.conf = conf;
//    }
//
//    public KnowledgeBase getKbase() {
//        return kbase;
//    }

    public void setKbase(KnowledgeBase kbase) {
        this.kbase = kbase;
    }

    public GridNode getNode() {
        return node;
    }

    public List<DroolsResourceAdapter> getResources() {
        return resources;
    }

    public void setResources(List<DroolsResourceAdapter> resources) {
        this.resources = resources;
    }

    public void setNode(GridNode gridNode) {
        this.node = gridNode;
    }

}
